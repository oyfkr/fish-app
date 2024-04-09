package fish.fish.domain.deal

import fish.fish.domain.account.Account
import fish.fish.domain.client.Client
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.data.jpa.repository.Modifying
import java.time.LocalDate
import java.time.LocalDateTime

@Table(name = "deal")
@Entity
@EntityListeners(AuditingEntityListener::class)
class Deal(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    var client: Client,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deal")
    var dealItem: MutableList<DealItem>?,

    @Column(name = "cnt")
    var cnt: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    var account: Account,

    @Column(name = "deal_date")
    var dealDate: LocalDate,

    @CreatedDate
    @Column(name = "created_date")
    var createdDate: LocalDateTime,

    @LastModifiedDate
    @Column(name = "modified_date")
    var modifiedDate: LocalDateTime?
) {
}
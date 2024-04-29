package fish.fish.domain.client

import jakarta.persistence.*

@Table(name = "client")
@Entity
class ClientAgent(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @Column(name = "name")
    var name : String?, // 성명

    @Column(name = "position")
    var position: String?, // 직책

    @Column(name = "extension")
    var extension: String?, // 내선번호

    @Column(name = "email")
    var email: String?, // 이메일

    @Column(name = "phoneNumber")
    var phoneNumber: String?, // 자택전화

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    var client: Client
) {
}
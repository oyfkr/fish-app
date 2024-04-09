package fish.fish.domain.client

import jakarta.persistence.*

@Table
@Entity
class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @Column(name = "name")
    var name : String,
) {
}
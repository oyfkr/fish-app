package fish.fish.domain.fish

import jakarta.persistence.*

@Entity
@Table
class Fish(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @Column(name = "name")
    var name : String,

    @Column(name = "code")
    var code : String
) {
}
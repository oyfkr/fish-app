package fish.fish.domain.account

import jakarta.persistence.*

@Entity
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var username: String,

    var password: String,
) {

    companion object{
        fun of(id : Long?, userId: String, password: String) : Account {
            return Account(id, userId, password)
        }
    }
}
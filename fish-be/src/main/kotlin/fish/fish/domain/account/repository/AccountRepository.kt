package fish.fish.domain.account.repository

import fish.fish.domain.account.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long>{

    fun findByUsername(username: String) : Account?
}
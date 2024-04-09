package fish.fish.auth

import fish.fish.domain.account.repository.AccountRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class PrincipalDetailService(
    val accountRepository: AccountRepository
) : UserDetailsService {

    override fun loadUserByUsername(userId: String?): UserDetails? {
        if(userId == null) {
            throw IllegalStateException("유저네임은 null 일 수 없습니다.")
        }
        val account = accountRepository.findByUsername(userId)
        if(account != null) {
            return PrincipalDetails(account)
        } else {
            throw IllegalStateException("유저가 존재하지 않습니다.")
        }
        return null
    }
}
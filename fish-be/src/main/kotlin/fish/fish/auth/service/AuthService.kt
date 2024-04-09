package fish.fish.auth.service

import fish.fish.auth.controller.request.AccountCreateRequest
import fish.fish.config.SecurityConfig
import fish.fish.domain.account.Account
import fish.fish.domain.account.AccountDTO
import fish.fish.domain.account.repository.AccountRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val accountRepository: AccountRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun createAccount(accountCreateRequest: AccountCreateRequest) : AccountDTO {
        val encodePassword: String = passwordEncoder.encode(accountCreateRequest.password)

        val account = Account.of(null, accountCreateRequest.accountId, encodePassword)
        val save = accountRepository.save(account)
        return AccountDTO(save.id, save.username)
    }
}
package fish.fish.auth.controller

import fish.fish.auth.controller.request.AccountCreateRequest
import fish.fish.auth.service.AuthService
import fish.fish.domain.account.AccountDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SignUpController(
    private val authService: AuthService
) {

    @PostMapping("/accounts")
    fun createAccount(
        @RequestBody accountCreateRequest: AccountCreateRequest
    ) : ResponseEntity<AccountDTO>{

        val createAccount = authService.createAccount(accountCreateRequest)

        return ResponseEntity.ok(createAccount)
    }
}
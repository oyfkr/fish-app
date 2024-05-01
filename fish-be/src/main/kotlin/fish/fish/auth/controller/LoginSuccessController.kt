package fish.fish.auth.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.ServletRequest
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpSession
import org.springframework.http.HttpHeaders
import org.springframework.security.core.context.SecurityContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginSuccessController {

    private val log = KotlinLogging.logger{}

    @PostMapping("success")
    fun successLogin(httpServletRequest : HttpServletRequest, asd : HttpSession) : String {

        return "성공"
    }
}
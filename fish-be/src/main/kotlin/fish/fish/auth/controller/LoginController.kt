package fish.fish.auth.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class LoginController {

    @GetMapping("/login-page")
    fun getLoginPage() : String {
        return "login";
    }

    @PostMapping("/sign-up")
    fun signUp() : String {
        return "ok";
    }

    @GetMapping("/home")
    fun getHome() : String{
        return "home"
    }

    @GetMapping("/login-fail")
    fun failLogin() : String{
        return "loginFail";
    }

    @GetMapping("/index")
    fun index() : String {
        return "index"
    }

    @GetMapping("/csrf-token")
    fun getCsrfToken(request: HttpServletRequest): ResponseEntity<String> {
        val csrfToken: CsrfToken =
            request.getAttribute(CsrfToken::class.java.getName()) as CsrfToken
        return ResponseEntity.ok(csrfToken.getToken())
    }
}
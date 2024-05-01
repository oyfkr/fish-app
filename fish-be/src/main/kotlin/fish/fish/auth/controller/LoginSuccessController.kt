package fish.fish.auth.controller

import jakarta.servlet.ServletRequest
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginSuccessController {

    @GetMapping("success")
    fun successLogin(httpServletRequest : HttpServletRequest) : String {

        return "성공"
    }
}
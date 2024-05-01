package fish.fish.config

import fish.fish.auth.PrincipalDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import kotlin.math.log


@Configuration
@EnableWebSecurity
class SecurityConfig(
    val principalDetailService: PrincipalDetailService
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }


    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {
        http
                .cors{
                    it.configurationSource(corsConfigurationSource())
                }
            .headers{
                headers -> headers.frameOptions { it.sameOrigin() }
            }
            .csrf {
//                it.disable()
                    it.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                it.ignoringRequestMatchers(AntPathRequestMatcher("/h2-console/**"))
            }
            .formLogin { login ->
//                login.loginPage("/login-page")
                login.usernameParameter("username")
                login.passwordParameter("password")
                login.loginProcessingUrl("/login")
                login.defaultSuccessUrl("/home",true)
                login.failureUrl("/login-fail")
            }
//            .sessionManagement{
//                it.invalidSessionUrl("/login")
////                it.
//            }
            .authorizeHttpRequests { request ->
//                request.requestMatchers("/**").permitAll()
                request.requestMatchers("/login-page").permitAll()
                request.requestMatchers("/login").permitAll()
                request.requestMatchers("/csrf-token").permitAll()
                request.requestMatchers("/login-fail").permitAll()
                request.requestMatchers("/accounts").permitAll()
                request.requestMatchers("/login.css").permitAll()
                request.requestMatchers("/static/**").permitAll()
                request.anyRequest().authenticated()
            }
            .logout {
                it.logoutUrl("/logout")
                    .logoutSuccessUrl("/login-page")
            }

        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("http://localhost:5173")
        configuration.allowedMethods = listOf("POST", "GET", "DELETE", "PUT")
        configuration.allowedHeaders = listOf("*")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

//    @Bean
//    fun configureGlobal(auth : AuthenticationManagerBuilder) {
//        auth.userDetailsService(principalDetailService).passwordEncoder(passwordEncoder())
//    }
}
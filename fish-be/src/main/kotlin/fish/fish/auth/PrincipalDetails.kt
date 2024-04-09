package fish.fish.auth

import fish.fish.domain.account.Account
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class PrincipalDetails(

    private var account: Account

) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        val authorities = ArrayList<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority("ROLE_USER"))
        return authorities
    }

    override fun getPassword(): String {
        // 사용자의 패스워드를 반환합니다.
        return account.password
    }

    override fun getUsername(): String {
        // 사용자의 아이디를 반환합니다.
        return account.username
    }

    override fun isAccountNonExpired(): Boolean {
        // 계정이 만료되지 않았는지를 반환합니다.
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        // 계정이 잠겨있지 않았는지를 반환합니다.
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        // 사용자의 자격 증명(패스워드 등)이 만료되지 않았는지를 반환합니다.
        return true
    }

    override fun isEnabled(): Boolean {
        // 사용자 계정이 활성화되어 있는지를 반환합니다.
        return true
    }
}
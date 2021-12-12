package io.github.tuguzt.sql.backend.spring.security

import io.github.tuguzt.sql.backend.spring.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsService(private val repository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findByLogin(username)
            ?: throw UsernameNotFoundException("User with username $username not found")
        return User(user.login, user.passwordEncrypted, setOf())
    }
}

package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.UserEntity
import io.github.tuguzt.sql.backend.spring.repository.UserRepository
import io.github.tuguzt.sql.backend.spring.security.JwtUtils
import io.github.tuguzt.sql.backend.spring.security.UserDetailsService
import io.github.tuguzt.sql.domain.interactor.checkPassword
import io.github.tuguzt.sql.domain.interactor.checkUsername
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val passwordEncoder: PasswordEncoder,
    private val userDetailsService: UserDetailsService,
    private val jwtUtils: JwtUtils,
    private val userRepository: UserRepository,
) {
    @PostMapping("auth")
    suspend fun auth(@RequestBody user: UserEntity): ResponseEntity<String> = try {
        val authentication = UsernamePasswordAuthenticationToken(user.login, user.passwordEncrypted)
        authenticationManager.authenticate(authentication)

        val userDetails = userDetailsService.loadUserByUsername(user.login)
        val token = jwtUtils.generateToken(userDetails)
        ResponseEntity.ok(token)
    } catch (e: BadCredentialsException) {
        ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
    } catch (e: UsernameNotFoundException) {
        ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
    } catch (e: Exception) {
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
    }

    @PostMapping("register")
    suspend fun register(@RequestBody user: UserEntity): ResponseEntity<String> = try {
        require(checkUsername(user.login) && checkPassword(user.passwordEncrypted))
        withContext(Dispatchers.IO) {
            require(userRepository.findByLogin(user.login) == null) {
                "User with login ${user.login} already exists"
            }
            @Suppress("NAME_SHADOWING")
            val user = UserEntity(
                login = user.login,
                passwordEncrypted = passwordEncoder.encode(user.passwordEncrypted),
                officer = user.officer,
            )
            userRepository.save(user)
        }

        auth(user)
    } catch (e: IllegalArgumentException) {
        ResponseEntity.badRequest().build()
    } catch (e: Exception) {
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
    }
}

package io.github.tuguzt.sql.backend.spring.security

import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtRequestFilter(
    private val userDetailsService: UserDetailsService,
    private val jwtUtils: JwtUtils,
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val header: String? = request.getHeader(HttpHeaders.AUTHORIZATION)
        kotlin.run {
            val prefix = "Bearer "
            if (header.isNullOrEmpty() || !header.startsWith(prefix)) return@run

            val token = header.substringAfter(prefix)
            val username = jwtUtils.extractLogin(token)
            val userDetails = userDetailsService.loadUserByUsername(username)
            if (!jwtUtils.validateToken(token, userDetails)) return@run

            val authentication = UsernamePasswordAuthenticationToken(userDetails, null, setOf())
            authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }
}

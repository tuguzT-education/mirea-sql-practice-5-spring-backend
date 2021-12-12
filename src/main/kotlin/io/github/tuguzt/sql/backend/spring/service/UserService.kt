package io.github.tuguzt.sql.backend.spring.service

import io.github.tuguzt.sql.backend.spring.model.UserEntity

interface UserService : EntityService<UserEntity, Int> {
    suspend fun findByLogin(login: String): UserEntity?
}

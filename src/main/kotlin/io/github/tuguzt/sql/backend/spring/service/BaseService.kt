package io.github.tuguzt.sql.backend.spring.service

import io.github.tuguzt.sql.domain.model.Identifiable

sealed interface BaseService<T : Identifiable<I>, I : Any> {
    suspend fun getAll(): Set<T>

    suspend fun save(item: T): T

    suspend fun delete(item: T)

    suspend fun findById(id: I): T?

    suspend fun deleteById(id: I)
}

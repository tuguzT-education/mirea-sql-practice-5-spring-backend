package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.service.EntityService
import io.github.tuguzt.sql.domain.model.Identifiable

sealed class EntityController<T : Identifiable<I>, I : Any> {
    protected abstract val service: EntityService<T, I>

    open suspend fun getAll(): Set<T> = service.getAll()

    open suspend fun insert(entity: T): T = service.insert(entity)

    open suspend fun update(entity: T): Unit = service.update(entity)

    open suspend fun delete(entity: T): Unit = service.delete(entity)

    open suspend fun findById(id: I): T? = service.findById(id)

    open suspend fun deleteById(id: I): Unit = service.deleteById(id)
}

package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import io.github.tuguzt.sql.backend.spring.orNull
import io.github.tuguzt.sql.backend.spring.repository.GameProjectDocumentationRepository
import io.github.tuguzt.sql.backend.spring.service.GameProjectDocumentationService
import org.springframework.stereotype.Service

@Service
class GameProjectDocumentationServiceImpl(
    private val repository: GameProjectDocumentationRepository,
) : GameProjectDocumentationService {

    override suspend fun getAll() = repository.findAll().toSet()

    override suspend fun insert(entity: GameProjectDocumentationEntity) = repository.save(entity)

    override suspend fun update(entity: GameProjectDocumentationEntity) =
        repository.update(entity.id, entity.businessPlan, entity.designDocument, entity.vision)

    override suspend fun delete(entity: GameProjectDocumentationEntity) = repository.delete(entity)

    override suspend fun findById(id: Int) = repository.findById(id).orNull()

    override suspend fun deleteById(id: Int) = repository.deleteById(id)

    override suspend fun exists(entity: GameProjectDocumentationEntity) = repository.existsById(entity.id)
}

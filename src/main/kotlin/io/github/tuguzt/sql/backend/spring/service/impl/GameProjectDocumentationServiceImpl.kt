package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import io.github.tuguzt.sql.backend.spring.orNull
import io.github.tuguzt.sql.backend.spring.repository.GameProjectDocumentationRepository
import io.github.tuguzt.sql.backend.spring.service.GameProjectDocumentationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class GameProjectDocumentationServiceImpl(
    private val repository: GameProjectDocumentationRepository,
) : GameProjectDocumentationService {

    override suspend fun getAll() = withContext(Dispatchers.IO) { repository.findAll().toSet() }

    override suspend fun insert(entity: GameProjectDocumentationEntity) =
        withContext(Dispatchers.IO) { repository.save(entity) }

    override suspend fun update(entity: GameProjectDocumentationEntity) =
        withContext(Dispatchers.IO) {
            repository.update(
                entity.id,
                entity.businessPlan,
                entity.designDocument,
                entity.vision,
            )
        }

    override suspend fun delete(entity: GameProjectDocumentationEntity) =
        withContext(Dispatchers.IO) { repository.delete(entity) }

    override suspend fun findById(id: Int) = withContext(Dispatchers.IO) { repository.findById(id).orNull() }

    override suspend fun deleteById(id: Int) = withContext(Dispatchers.IO) { repository.deleteById(id) }

    override suspend fun exists(entity: GameProjectDocumentationEntity) =
        withContext(Dispatchers.IO) { repository.existsById(entity.id) }
}

package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameProjectEntity
import io.github.tuguzt.sql.backend.spring.orNull
import io.github.tuguzt.sql.backend.spring.repository.GameProjectRepository
import io.github.tuguzt.sql.backend.spring.service.GameProjectService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class GameProjectServiceImpl(private val repository: GameProjectRepository) : GameProjectService {
    override suspend fun getAll() = withContext(Dispatchers.IO) { repository.findAll().toSet() }

    override suspend fun insert(entity: GameProjectEntity): GameProjectEntity {
        val result = withContext(Dispatchers.IO) {
            repository.rawInsert(entity.name, entity.description, entity.documentation.id)
            repository.findByName(entity.name)
        }
        return requireNotNull(result)
    }

    override suspend fun update(entity: GameProjectEntity) = withContext(Dispatchers.IO) {
        repository.update(entity.id, entity.name, entity.description, entity.documentation.id)
    }

    override suspend fun delete(entity: GameProjectEntity) = withContext(Dispatchers.IO) { repository.delete(entity) }

    override suspend fun findById(id: Int) = withContext(Dispatchers.IO) { repository.findById(id).orNull() }

    override suspend fun deleteById(id: Int) = withContext(Dispatchers.IO) { repository.deleteById(id) }

    override suspend fun exists(entity: GameProjectEntity) =
        withContext(Dispatchers.IO) { repository.existsById(entity.id) }
}

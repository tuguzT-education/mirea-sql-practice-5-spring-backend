package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameProjectVersionEntity
import io.github.tuguzt.sql.backend.spring.repository.GameProjectVersionRepository
import io.github.tuguzt.sql.backend.spring.service.GameProjectVersionService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GameProjectVersionServiceImpl(private val repository: GameProjectVersionRepository) : GameProjectVersionService {
    override suspend fun getAll() = withContext(Dispatchers.IO) { repository.findAll().toSet() }

    override suspend fun save(entity: GameProjectVersionEntity) =
        withContext(Dispatchers.IO) { repository.save(entity) }

    override suspend fun delete(entity: GameProjectVersionEntity) =
        withContext(Dispatchers.IO) { repository.delete(entity) }

    override suspend fun findById(id: Int) = withContext(Dispatchers.IO) { repository.findByIdOrNull(id) }

    override suspend fun deleteById(id: Int) = withContext(Dispatchers.IO) { repository.deleteById(id) }

    override suspend fun exists(entity: GameProjectVersionEntity) =
        withContext(Dispatchers.IO) { repository.existsById(entity.id) }
}

package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameProjectPlatformEntity
import io.github.tuguzt.sql.backend.spring.repository.GameProjectPlatformRepository
import io.github.tuguzt.sql.backend.spring.service.GameProjectPlatformService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GameProjectPlatformServiceImpl(
    private val repository: GameProjectPlatformRepository,
) : GameProjectPlatformService {

    override suspend fun getAll() = withContext(Dispatchers.IO) { repository.findAll().toSet() }

    override suspend fun save(entity: GameProjectPlatformEntity) =
        withContext(Dispatchers.IO) { repository.save(entity) }

    override suspend fun delete(entity: GameProjectPlatformEntity) =
        withContext(Dispatchers.IO) { repository.delete(entity) }

    override suspend fun findById(id: Int) = withContext(Dispatchers.IO) { repository.findByIdOrNull(id) }

    override suspend fun deleteById(id: Int) = withContext(Dispatchers.IO) { repository.deleteById(id) }

    override suspend fun exists(entity: GameProjectPlatformEntity) =
        withContext(Dispatchers.IO) { repository.existsById(entity.id) }
}

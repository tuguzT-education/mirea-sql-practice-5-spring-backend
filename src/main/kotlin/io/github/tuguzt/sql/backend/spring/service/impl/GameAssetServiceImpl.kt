package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameAssetEntity
import io.github.tuguzt.sql.backend.spring.repository.GameAssetRepository
import io.github.tuguzt.sql.backend.spring.service.GameAssetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GameAssetServiceImpl(private val repository: GameAssetRepository) : GameAssetService {
    override suspend fun findByName(name: String) = withContext(Dispatchers.IO) { repository.findByName(name) }

    override suspend fun getAll() = withContext(Dispatchers.IO) { repository.findAll().toSet() }

    override suspend fun save(entity: GameAssetEntity) = withContext(Dispatchers.IO) { repository.save(entity) }

    override suspend fun delete(entity: GameAssetEntity) = withContext(Dispatchers.IO) { repository.delete(entity) }

    override suspend fun findById(id: Int) = withContext(Dispatchers.IO) { repository.findByIdOrNull(id) }

    override suspend fun deleteById(id: Int) = withContext(Dispatchers.IO) { repository.deleteById(id) }

    override suspend fun exists(entity: GameAssetEntity) =
        withContext(Dispatchers.IO) { repository.existsById(entity.id) }
}

package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import io.github.tuguzt.sql.backend.spring.repository.GameAssetTypeRepository
import io.github.tuguzt.sql.backend.spring.service.GameAssetTypeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GameAssetTypeServiceImpl(private val repository: GameAssetTypeRepository) : GameAssetTypeService {
    override suspend fun getAll() = withContext(Dispatchers.IO) { repository.findAll().toSet() }

    override suspend fun save(entity: GameAssetTypeEntity) = withContext(Dispatchers.IO) { repository.save(entity) }

    override suspend fun delete(entity: GameAssetTypeEntity) = withContext(Dispatchers.IO) { repository.delete(entity) }

    override suspend fun findById(id: Int) = withContext(Dispatchers.IO) { repository.findByIdOrNull(id) }

    override suspend fun deleteById(id: Int) = withContext(Dispatchers.IO) { repository.deleteById(id) }

    override suspend fun exists(entity: GameAssetTypeEntity) =
        withContext(Dispatchers.IO) { repository.existsById(entity.id) }
}

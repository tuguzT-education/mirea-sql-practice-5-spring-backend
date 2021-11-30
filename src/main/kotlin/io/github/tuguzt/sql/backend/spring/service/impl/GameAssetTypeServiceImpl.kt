package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import io.github.tuguzt.sql.backend.spring.orNull
import io.github.tuguzt.sql.backend.spring.repository.GameAssetTypeRepository
import io.github.tuguzt.sql.backend.spring.service.GameAssetTypeService
import org.springframework.stereotype.Service

@Service
class GameAssetTypeServiceImpl(private val repository: GameAssetTypeRepository) : GameAssetTypeService {
    override suspend fun getAll() = repository.findAll().toSet()

    override suspend fun insert(entity: GameAssetTypeEntity) = repository.save(entity)

    override suspend fun update(entity: GameAssetTypeEntity) = repository.update(entity.id, entity.name)

    override suspend fun delete(entity: GameAssetTypeEntity) = repository.delete(entity)

    override suspend fun findById(id: Int) = repository.findById(id).orNull()

    override suspend fun deleteById(id: Int) = repository.deleteById(id)

    override suspend fun exists(entity: GameAssetTypeEntity) = repository.existsById(entity.id)
}

package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import io.github.tuguzt.sql.backend.spring.orNull
import io.github.tuguzt.sql.backend.spring.repository.GameAssetTypeRepository
import io.github.tuguzt.sql.backend.spring.service.GameAssetTypeService
import org.springframework.stereotype.Service

@Service
class GameAssetTypeServiceImpl(private val repository: GameAssetTypeRepository) : GameAssetTypeService {
    override suspend fun getAll() = repository.findAll().toSet()

    override suspend fun save(item: GameAssetTypeEntity) = repository.save(item)

    override suspend fun delete(item: GameAssetTypeEntity) = repository.delete(item)

    override suspend fun findById(id: Int) = repository.findById(id).orNull()

    override suspend fun deleteById(id: Int) = repository.deleteById(id)
}

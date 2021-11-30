package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameAssetEntity
import io.github.tuguzt.sql.backend.spring.orNull
import io.github.tuguzt.sql.backend.spring.repository.GameAssetRepository
import io.github.tuguzt.sql.backend.spring.service.GameAssetService
import org.springframework.stereotype.Service

@Service
class GameAssetServiceImpl(private val repository: GameAssetRepository) : GameAssetService {
    override suspend fun getAll() = repository.findAll().toSet()

    override suspend fun save(item: GameAssetEntity) = repository.save(item)

    override suspend fun delete(item: GameAssetEntity) = repository.delete(item)

    override suspend fun findById(id: Int) = repository.findById(id).orNull()

    override suspend fun deleteById(id: Int) = repository.deleteById(id)
}

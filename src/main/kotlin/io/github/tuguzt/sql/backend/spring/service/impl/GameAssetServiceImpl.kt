package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameAssetEntity
import io.github.tuguzt.sql.backend.spring.orNull
import io.github.tuguzt.sql.backend.spring.repository.GameAssetRepository
import io.github.tuguzt.sql.backend.spring.service.GameAssetService
import org.springframework.stereotype.Service

@Service
class GameAssetServiceImpl(private val repository: GameAssetRepository) : GameAssetService {
    override suspend fun findByName(name: String) = repository.findByName(name)

    override suspend fun getAll() = repository.findAll().toSet()

    override suspend fun insert(entity: GameAssetEntity): GameAssetEntity {
        val gameProject = requireNotNull(entity.gameProject) { "Game object is required" }
        repository.rawInsert(entity.name, entity.description, entity.dataUri, entity.type.id, gameProject.id)

        return requireNotNull(repository.findByName(entity.name))
    }

    override suspend fun update(entity: GameAssetEntity) {
        val gameProject = requireNotNull(entity.gameProject) { "Item cannot be in database" }
        repository.update(entity.id, entity.name, entity.description, entity.dataUri, entity.type.id, gameProject.id)
    }

    override suspend fun delete(entity: GameAssetEntity) = repository.delete(entity)

    override suspend fun findById(id: Int) = repository.findById(id).orNull()

    override suspend fun deleteById(id: Int) = repository.deleteById(id)

    override suspend fun exists(entity: GameAssetEntity) = repository.existsById(entity.id)
}

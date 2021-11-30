package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameAssetEntity
import io.github.tuguzt.sql.backend.spring.orNull
import io.github.tuguzt.sql.backend.spring.repository.GameAssetRepository
import io.github.tuguzt.sql.backend.spring.service.GameAssetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class GameAssetServiceImpl(private val repository: GameAssetRepository) : GameAssetService {
    override suspend fun findByName(name: String) = withContext(Dispatchers.IO) { repository.findByName(name) }

    override suspend fun getAll() = withContext(Dispatchers.IO) { repository.findAll().toSet() }

    override suspend fun insert(entity: GameAssetEntity): GameAssetEntity {
        val gameProject = requireNotNull(entity.gameProject) { "Game object is required" }
        val result = withContext(Dispatchers.IO) {
            repository.rawInsert(entity.name, entity.description, entity.dataUri, entity.type.id, gameProject.id)
            repository.findByName(entity.name)
        }
        return requireNotNull(result)
    }

    override suspend fun update(entity: GameAssetEntity) {
        val gameProject = requireNotNull(entity.gameProject) { "Item cannot be in database" }
        withContext(Dispatchers.IO) {
            repository.update(
                entity.id,
                entity.name,
                entity.description,
                entity.dataUri,
                entity.type.id,
                gameProject.id,
            )
        }
    }

    override suspend fun delete(entity: GameAssetEntity) = withContext(Dispatchers.IO) { repository.delete(entity) }

    override suspend fun findById(id: Int) = withContext(Dispatchers.IO) { repository.findById(id).orNull() }

    override suspend fun deleteById(id: Int) = withContext(Dispatchers.IO) { repository.deleteById(id) }

    override suspend fun exists(entity: GameAssetEntity) =
        withContext(Dispatchers.IO) { repository.existsById(entity.id) }
}

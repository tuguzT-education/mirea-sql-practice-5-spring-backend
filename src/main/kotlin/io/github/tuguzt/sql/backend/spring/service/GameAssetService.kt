package io.github.tuguzt.sql.backend.spring.service

import io.github.tuguzt.sql.backend.spring.model.GameAssetEntity

interface GameAssetService : EntityService<GameAssetEntity, Int> {
    suspend fun findByName(name: String): GameAssetEntity?
}

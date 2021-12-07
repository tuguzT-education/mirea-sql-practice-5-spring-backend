package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(private val gameAssetTypeRepository: GameAssetTypeRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val gameAssetTypes = listOf(
            GameAssetTypeEntity(name = "Texture"),
            GameAssetTypeEntity(name = "Material"),
            GameAssetTypeEntity(name = "Level"),
        )
        gameAssetTypeRepository.saveAll(gameAssetTypes)
    }
}

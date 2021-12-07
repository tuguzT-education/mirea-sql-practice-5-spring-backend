package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import kotlin.test.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.assertTrue

@DataJpaTest
class GameAssetTypeTests(@Autowired private val gameAssetTypeRepository: GameAssetTypeRepository) {
    @Test
    fun `game asset types`() {
        val all = gameAssetTypeRepository.saveAll(
            listOf(
                GameAssetTypeEntity(name = "Texture"),
                GameAssetTypeEntity(name = "Material"),
                GameAssetTypeEntity(name = "Level"),
            )
        )
        assertTrue { all.isNotEmpty() && all.size == 3 }
        assertTrue { all.find { it.name == "Texture" } != null }
    }
}

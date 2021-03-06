package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@DataJpaTest
class GameAssetTypeTests(@Autowired private val repository: GameAssetTypeRepository) {
    @Test
    fun insert() {
        val all = repository.saveAll(
            listOf(
                GameAssetTypeEntity(name = "Texture"),
                GameAssetTypeEntity(name = "Material"),
                GameAssetTypeEntity(name = "Level"),
            )
        )
        assertTrue { all.isNotEmpty() && all.size == 3 }
        assertTrue { all.find { it.name == "Texture" } != null }
    }

    @Test
    fun update() {
        val entity = repository.save(GameAssetTypeEntity(name = "Texture"))
        entity.name = "Art"
        val newEntity = repository.save(entity)
        assertEquals(entity, newEntity)
        assertEquals(newEntity, repository.findByIdOrNull(newEntity.id))

        val proxy = repository.getById(newEntity.id)
        proxy.name = "Character"
        val newNewEntity = repository.save(proxy)
        assertEquals(newNewEntity, newEntity)
        assertEquals(newNewEntity, repository.findByIdOrNull(newNewEntity.id))
    }
}

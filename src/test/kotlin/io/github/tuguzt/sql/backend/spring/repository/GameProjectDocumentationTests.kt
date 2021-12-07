package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@DataJpaTest
class GameProjectDocumentationTests(@Autowired private val repository: GameProjectDocumentationRepository) {
    @Test
    fun insert() {
        val all = repository.saveAll(
            listOf(
                GameProjectDocumentationEntity(businessPlan = "idk", designDocument = "idk", vision = "idk"),
                GameProjectDocumentationEntity(businessPlan = "hello", designDocument = "hello", vision = "hello"),
            )
        )
        assertTrue { all.isNotEmpty() && all.size == 2 }
        assertTrue { all.find { it.businessPlan == "idk" } != null }
    }

    @Test
    fun update() {
        val entity = repository.save(
            GameProjectDocumentationEntity(
                businessPlan = "idk",
                designDocument = "idk",
                vision = "idk"
            )
        )
        entity.vision = "hello world"
        val newEntity = repository.save(entity)
        assertEquals(entity, newEntity)
        assertEquals(newEntity, repository.findByIdOrNull(newEntity.id))

        val proxy = repository.getById(newEntity.id)
        proxy.businessPlan = "Character"
        val newNewEntity = repository.save(proxy)
        assertEquals(newNewEntity, newEntity)
        assertEquals(newNewEntity, repository.findByIdOrNull(newNewEntity.id))
    }
}

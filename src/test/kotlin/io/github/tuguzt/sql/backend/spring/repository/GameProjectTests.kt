package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import io.github.tuguzt.sql.backend.spring.model.GameProjectEntity
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.Test
import kotlin.test.assertTrue

@DataJpaTest
class GameProjectTests(
    @Autowired private val gameProjectDocumentationRepository: GameProjectDocumentationRepository,
    @Autowired private val gameProjectRepository: GameProjectRepository,
) {
    @Test
    fun `game projects`() {
        val gameProject = assertDoesNotThrow {
            val documentation = kotlin.run {
                val documentation = GameProjectDocumentationEntity(
                    businessPlan = "idk",
                    designDocument = "idk",
                    vision = "idk",
                )
                gameProjectDocumentationRepository.save(documentation)
            }
            val gameProject = GameProjectEntity(
                name = "Some game project",
                description = "IDK",
                documentation = documentation,
                assets = setOf(),
                versions = setOf(),
                platforms = setOf(),
                organizations = setOf(),
            )
            gameProjectRepository.save(gameProject)
        }
        assertTrue { gameProject.id == 1 }
    }
}

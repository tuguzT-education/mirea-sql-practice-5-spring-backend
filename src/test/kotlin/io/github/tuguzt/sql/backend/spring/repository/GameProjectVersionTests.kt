package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import io.github.tuguzt.sql.backend.spring.model.GameProjectEntity
import io.github.tuguzt.sql.backend.spring.model.GameProjectVersionEntity
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.Test
import kotlin.test.assertTrue

@DataJpaTest
class GameProjectVersionTests(
    @Autowired private val repository: GameProjectVersionRepository,
    @Autowired private val gameProjectDocumentationRepository: GameProjectDocumentationRepository,
    @Autowired private val gameProjectRepository: GameProjectRepository,
) {
    @Test
    fun insert() {
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
        val version = repository.save(
            GameProjectVersionEntity(
                hash = "ksfhgjkhf",
                major = 1,
                minor = 0,
                patch = 0,
                metadata = "",
                gameProject = gameProject,
            )
        )
        assertTrue { version.id == 1 }
    }
}

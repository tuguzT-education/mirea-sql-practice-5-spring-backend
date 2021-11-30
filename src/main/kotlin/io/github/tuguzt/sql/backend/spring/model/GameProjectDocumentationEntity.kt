package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameProjectDocumentation
import kotlinx.serialization.Serializable
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_project_documentation")
@Serializable
class GameProjectDocumentationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_documentation_id")
    override val id: Int,

    @Column(name = "game_project_business_plan")
    override val businessPlan: String,

    @Column(name = "game_project_design_document")
    override val designDocument: String,

    @Column(name = "game_project_vision")
    override val vision: String,
) : GameProjectDocumentation {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as GameProjectDocumentationEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

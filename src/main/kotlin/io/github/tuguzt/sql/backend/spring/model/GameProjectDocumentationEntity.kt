package io.github.tuguzt.sql.backend.spring.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tuguzt.sql.domain.model.GameProjectDocumentation
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_project_documentation")
class GameProjectDocumentationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_documentation_id")
    override val id: Int = 0,

    @JsonProperty("business_plan")
    @Column(name = "game_project_business_plan")
    override var businessPlan: String,

    @JsonProperty("design_document")
    @Column(name = "game_project_design_document")
    override var designDocument: String,

    @Column(name = "game_project_vision")
    override var vision: String,
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

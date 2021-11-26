package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameProjectDocumentation
import javax.persistence.*

@Entity
@Table(name = "game_project_documentation")
class GameProjectDocumentationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_documentation_id")
    val id: Int,

    @Column(name = "game_project_business_plan")
    override val businessPlan: String,

    @Column(name = "game_project_design_document")
    override val designDocument: String,

    @Column(name = "game_project_vision")
    override val vision: String,
) : GameProjectDocumentation

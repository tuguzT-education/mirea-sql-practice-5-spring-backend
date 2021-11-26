package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "game_project_documentation")
class GameProjectDocumentation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_documentation_id")
    val id: Int,

    @Column(name = "game_project_business_plan")
    val businessPlan: String,

    @Column(name = "game_project_design_document")
    val designDocument: String,

    @Column(name = "game_project_vision")
    val vision: String,
)

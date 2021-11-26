package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "game_project_platform")
class GameProjectPlatform(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_platform_id")
    val id: Int,

    @Column(name = "game_project_platform_name", length = 20)
    val name: String,

    @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "platforms")
    val gameProjects: Set<GameProject>,
)

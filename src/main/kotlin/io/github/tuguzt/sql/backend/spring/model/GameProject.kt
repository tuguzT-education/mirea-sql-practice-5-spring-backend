package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "game_project")
class GameProject(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_id")
    val id: Int,

    @Column(name = "game_project_name", length = 100)
    val name: String,

    @Column(name = "game_project_description")
    val description: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_project_documentation_id", referencedColumnName = "game_project_documentation_id")
    val documentation: GameProjectDocumentation,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "platform_to_game_project",
        joinColumns = [JoinColumn(name = "game_project_id")],
        inverseJoinColumns = [JoinColumn(name = "game_project_platform_id")],
    )
    val platforms: Set<GameProjectPlatform>,

    @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "gameProjects")
    val organizations: Set<Organization>,
)

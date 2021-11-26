package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "game_project_version")
class GameProjectVersion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_version_id")
    val id: Int,

    @Column(name = "game_project_version_hash", length = 40)
    val hash: String,

    @Column(name = "game_project_version_major")
    val major: Int,

    @Column(name = "game_project_version_minor")
    val minor: Int,

    @Column(name = "game_project_version_patch")
    val patch: Int,

    @Column(name = "game_project_version_metadata", length = 255)
    val metadata: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_project_id", referencedColumnName = "game_project_id")
    val gameProject: GameProject,
)

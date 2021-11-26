package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "game_asset")
class GameAsset(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_asset_id")
    val id: Int,

    @Column(name = "game_asset_name", length = 100)
    val name: String,

    @Column(name = "game_asset_description")
    val description: String,

    @Column(name = "game_asset_data")
    val dataUri: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_asset_type_id", referencedColumnName = "game_asset_type_id")
    val type: GameAssetType,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_project_id", referencedColumnName = "game_project_id")
    val gameProject: GameProject,
)

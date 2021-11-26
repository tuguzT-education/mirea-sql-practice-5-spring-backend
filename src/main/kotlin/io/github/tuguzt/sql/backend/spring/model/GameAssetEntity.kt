package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameAsset
import javax.persistence.*

@Entity
@Table(name = "game_asset")
class GameAssetEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_asset_id")
    val id: Int,

    @Column(name = "game_asset_name", length = 100)
    override val name: String,

    @Column(name = "game_asset_description")
    override val description: String,

    @Column(name = "game_asset_data")
    override val dataUri: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_asset_type_id", referencedColumnName = "game_asset_type_id")
    override val type: GameAssetTypeEntity,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_project_id", referencedColumnName = "game_project_id")
    val gameProject: GameProjectEntity,
) : GameAsset

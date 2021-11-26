package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameAssetType
import javax.persistence.*

@Entity
@Table(name = "game_asset_type")
class GameAssetTypeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_asset_type_id")
    val id: Int,

    @Column(name = "game_asset_type_name", length = 100)
    override val name: String,
) : GameAssetType

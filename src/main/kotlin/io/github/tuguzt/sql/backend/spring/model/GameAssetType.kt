package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "game_asset_type")
class GameAssetType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_asset_type_id")
    var id: Int,

    @Column(name = "game_asset_type_name", length = 100)
    var name: String,
)

package io.github.tuguzt.sql.backend.spring.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tuguzt.sql.domain.model.GameAsset
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_asset")
class GameAssetEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_asset_id")
    override val id: Int = 0,

    @Column(name = "game_asset_name", length = 100, unique = true)
    override var name: String,

    @Column(name = "game_asset_description")
    override var description: String,

    @JsonProperty("data_uri")
    @Column(name = "game_asset_data", unique = true)
    override var dataUri: String,

    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "game_asset_type_id", referencedColumnName = "game_asset_type_id")
    override var type: GameAssetTypeEntity,

    @JsonProperty("game_project")
    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "game_project_id", referencedColumnName = "game_project_id")
    override var gameProject: GameProjectEntity,
) : GameAsset {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as GameAssetEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

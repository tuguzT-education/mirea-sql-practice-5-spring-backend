package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameAsset
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_asset")
@Serializable
class GameAssetEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_asset_id")
    override val id: Int = 0,

    @Column(name = "game_asset_name", length = 100, unique = true)
    override val name: String,

    @Column(name = "game_asset_description")
    override val description: String,

    @Column(name = "game_asset_data", unique = true)
    override val dataUri: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_asset_type_id", referencedColumnName = "game_asset_type_id")
    override val type: GameAssetTypeEntity,

    @Transient
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_project_id", referencedColumnName = "game_project_id")
    val gameProject: GameProjectEntity? = null,
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

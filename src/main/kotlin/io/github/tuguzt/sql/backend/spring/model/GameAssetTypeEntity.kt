package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameAssetType
import kotlinx.serialization.Serializable
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_asset_type")
@Serializable
class GameAssetTypeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_asset_type_id")
    override val id: Int = 0,

    @Column(name = "game_asset_type_name", length = 100, unique = true)
    override val name: String,
) : GameAssetType {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as GameAssetTypeEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

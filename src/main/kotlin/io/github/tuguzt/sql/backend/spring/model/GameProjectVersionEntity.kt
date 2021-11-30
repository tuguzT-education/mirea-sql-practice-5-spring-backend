package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameProjectVersion
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_project_version")
@Serializable
class GameProjectVersionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_version_id")
    override val id: Int = 0,

    @Column(name = "game_project_version_hash", length = 40, unique = true)
    override val hash: String,

    @Column(name = "game_project_version_major")
    override val major: Int,

    @Column(name = "game_project_version_minor")
    override val minor: Int,

    @Column(name = "game_project_version_patch")
    override val patch: Int,

    @Column(name = "game_project_version_metadata", length = 255)
    override val metadata: String,

    @Transient
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_project_id", referencedColumnName = "game_project_id")
    val gameProject: GameProjectEntity? = null,
) : GameProjectVersion {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as GameProjectVersionEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

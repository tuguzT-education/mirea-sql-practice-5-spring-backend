package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameProjectVersion
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
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
    override var hash: String,

    @Column(name = "game_project_version_major")
    override var major: Int,

    @Column(name = "game_project_version_minor")
    override var minor: Int,

    @Column(name = "game_project_version_patch")
    override var patch: Int,

    @Column(name = "game_project_version_metadata", length = 255)
    override var metadata: String,

    @SerialName("game_project")
    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "game_project_id", referencedColumnName = "game_project_id")
    override var gameProject: GameProjectEntity,
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

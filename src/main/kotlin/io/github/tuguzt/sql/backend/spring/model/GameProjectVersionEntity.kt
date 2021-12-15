package io.github.tuguzt.sql.backend.spring.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tuguzt.sql.domain.model.GameProjectVersion
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_project_version")
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

    @JsonBackReference
    @JsonProperty("game_project")
    @ManyToOne(fetch = FetchType.EAGER)
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

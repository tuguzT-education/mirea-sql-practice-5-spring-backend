package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameProjectPlatform
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_project_platform")
@Serializable
class GameProjectPlatformEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_platform_id")
    override val id: Int = 0,

    @Column(name = "game_project_platform_name", length = 20, unique = true)
    override var name: String,

    @SerialName("game_projects")
    @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "platforms", fetch = FetchType.EAGER)
    override val gameProjects: Set<GameProjectEntity>,
) : GameProjectPlatform {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as GameProjectPlatformEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

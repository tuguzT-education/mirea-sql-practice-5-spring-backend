package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameProjectPlatform
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_project_platform")
class GameProjectPlatformEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_platform_id")
    override val id: Int,

    @Column(name = "game_project_platform_name", length = 20)
    override val name: String,

    @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "platforms")
    val gameProjects: Set<GameProjectEntity>,
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

package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.GameProject
import kotlinx.serialization.Serializable
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "game_project")
@Serializable
class GameProjectEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_project_id")
    override val id: Int = 0,

    @Column(name = "game_project_name", length = 100, unique = true)
    override val name: String,

    @Column(name = "game_project_description")
    override val description: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "game_project_documentation_id", referencedColumnName = "game_project_documentation_id")
    override val documentation: GameProjectDocumentationEntity,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "gameProject")
    override val assets: MutableSet<GameAssetEntity>,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "gameProject")
    override val versions: MutableSet<GameProjectVersionEntity>,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "platform_to_game_project",
        joinColumns = [JoinColumn(name = "game_project_id")],
        inverseJoinColumns = [JoinColumn(name = "game_project_platform_id")],
    )
    override val platforms: MutableSet<GameProjectPlatformEntity>,

    @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "gameProjects")
    override val organizations: MutableSet<OrganizationEntity>,
) : GameProject {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as GameProjectEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

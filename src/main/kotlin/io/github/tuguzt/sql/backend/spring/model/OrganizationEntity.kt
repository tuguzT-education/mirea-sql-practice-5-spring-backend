package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.Organization
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "organization")
@Serializable
class OrganizationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    override val id: Int = 0,

    @Column(name = "organization_name", length = 100, unique = true)
    override var name: String,

    @Column(name = "organization_description")
    override var description: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "organization_type_id", referencedColumnName = "organization_type_id")
    override var type: OrganizationTypeEntity,

    @SerialName("test_document")
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "test_document_id", referencedColumnName = "test_document_id")
    override var testDocument: TestDocumentEntity?,

    @SerialName("game_projects")
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "organization_to_game_project",
        joinColumns = [JoinColumn(name = "organization_id")],
        inverseJoinColumns = [JoinColumn(name = "game_project_id")],
    )
    override val gameProjects: Set<GameProjectEntity>,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "organization", fetch = FetchType.EAGER)
    override val officers: Set<OfficerEntity>,
) : Organization {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as OrganizationEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

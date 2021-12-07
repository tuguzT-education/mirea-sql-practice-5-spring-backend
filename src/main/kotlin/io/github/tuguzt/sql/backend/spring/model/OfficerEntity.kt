package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.Officer
import kotlinx.serialization.Serializable
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "officer")
@Serializable
class OfficerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_id")
    override val id: Int = 0,

    @Column(name = "officer_name", length = 200)
    override var name: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "officer_role_id", referencedColumnName = "officer_role_id")
    override var role: OfficerRoleEntity,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "organization_id", referencedColumnName = "organization_id")
    override var organization: OrganizationEntity,
) : Officer {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as OfficerEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

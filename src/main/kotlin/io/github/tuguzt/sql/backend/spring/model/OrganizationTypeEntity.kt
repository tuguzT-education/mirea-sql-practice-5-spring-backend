package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.OrganizationType
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "organization_type")
class OrganizationTypeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_type_id")
    val id: Int,

    @Column(name = "organization_type_name", length = 20)
    override val name: String,
) : OrganizationType {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as OrganizationTypeEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

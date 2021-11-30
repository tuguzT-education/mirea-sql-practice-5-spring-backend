package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.OfficerRole
import kotlinx.serialization.Serializable
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "officer_role")
@Serializable
class OfficerRoleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_role_id")
    override val id: Int = 0,

    @Column(name = "officer_role_name", length = 20, unique = true)
    override val name: String,
) : OfficerRole {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as OfficerRoleEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

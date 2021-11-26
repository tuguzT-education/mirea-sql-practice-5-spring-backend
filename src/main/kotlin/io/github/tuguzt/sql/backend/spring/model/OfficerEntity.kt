package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.Officer
import javax.persistence.*

@Entity
@Table(name = "officer")
class OfficerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_id")
    val id: Int,

    @Column(name = "officer_name", length = 200)
    override val name: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "officer_role_id", referencedColumnName = "officer_role_id")
    override val role: OfficerRoleEntity,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "organization_id", referencedColumnName = "organization_id")
    val organization: OrganizationEntity,
) : Officer

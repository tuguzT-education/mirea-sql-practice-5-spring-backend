package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.OfficerRole
import javax.persistence.*

@Entity
@Table(name = "officer_role")
class OfficerRoleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_role_id")
    val id: Int,

    @Column(name = "officer_role_name", length = 20)
    override val name: String,
) : OfficerRole

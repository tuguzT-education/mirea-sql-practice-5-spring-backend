package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.OrganizationType
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
) : OrganizationType

package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "organization_type")
class OrganizationType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_type_id")
    val id: Int,

    @Column(name = "organization_type_name", length = 20)
    val name: String,
)

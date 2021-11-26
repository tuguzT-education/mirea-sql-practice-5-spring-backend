package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "officer_role")
class OfficerRole(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_role_id")
    val id: Int,

    @Column(name = "officer_role_name", length = 20)
    val name: String,
)

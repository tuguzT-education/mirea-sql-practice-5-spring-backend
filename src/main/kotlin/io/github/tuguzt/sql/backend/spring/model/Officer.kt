package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "officer")
class Officer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_id")
    val id: Int,

    @Column(name = "officer_name", length = 200)
    val name: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "officer_role_id", referencedColumnName = "officer_role_id")
    val role: OfficerRole,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "organization_id", referencedColumnName = "organization_id")
    val organization: Organization,
)

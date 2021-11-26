package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "organization")
class Organization(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    val id: Int,

    @Column(name = "organization_name", length = 100)
    val name: String,

    @Column(name = "organization_description")
    val description: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "organization_type_id", referencedColumnName = "organization_type_id")
    val type: OrganizationType,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "test_document_id", referencedColumnName = "test_document_id")
    val testDocument: TestDocument?,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "organization_to_game_project",
        joinColumns = [JoinColumn(name = "organization_id")],
        inverseJoinColumns = [JoinColumn(name = "game_project_id")],
    )
    val gameProjects: Set<GameProject>,
)

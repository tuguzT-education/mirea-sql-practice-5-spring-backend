package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "test_level")
class TestLevel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_level_id")
    val id: Int,

    @Column(name = "test_level_name", length = 20)
    val name: String,
)

package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.TestLevel
import javax.persistence.*

@Entity
@Table(name = "test_level")
class TestLevelEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_level_id")
    val id: Int,

    @Column(name = "test_level_name", length = 20)
    override val name: String,
) : TestLevel

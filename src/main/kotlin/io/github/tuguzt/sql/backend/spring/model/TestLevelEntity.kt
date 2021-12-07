package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.TestLevel
import kotlinx.serialization.Serializable
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "test_level")
@Serializable
class TestLevelEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_level_id")
    override val id: Int = 0,

    @Column(name = "test_level_name", length = 20, unique = true)
    override var name: String,
) : TestLevel {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as TestLevelEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

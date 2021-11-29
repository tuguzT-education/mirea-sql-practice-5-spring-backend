package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.TestDocument
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "test_document")
class TestDocumentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_document_id")
    override val id: Int,

    @Column(name = "test_document_data")
    override val data: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "test_level_id", referencedColumnName = "test_level_id")
    override val level: TestLevelEntity,
) : TestDocument {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as TestDocumentEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

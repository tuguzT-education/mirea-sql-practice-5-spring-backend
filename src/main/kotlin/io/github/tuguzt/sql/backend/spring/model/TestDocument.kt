package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "test_document")
class TestDocument(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_document_id")
    val id: Int,

    @Column(name = "test_document_data")
    val data: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "test_level_id", referencedColumnName = "test_level_id")
    val level: TestLevel,
)

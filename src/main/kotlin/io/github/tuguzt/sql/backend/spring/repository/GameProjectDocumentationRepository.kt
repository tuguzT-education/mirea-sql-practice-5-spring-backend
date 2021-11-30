package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface GameProjectDocumentationRepository : JpaRepository<GameProjectDocumentationEntity, Int> {
    @Transactional
    @Modifying
    @Query(
        """
            update GameProjectDocumentationEntity as doc
            set doc.businessPlan = :businessPlan,
                doc.designDocument = :designDocument,
                doc.vision = :vision
            where doc.id = :id
        """
    )
    fun update(
        @Param("id") id: Int,
        @Param("businessPlan") businessPlan: String,
        @Param("designDocument") designDocument: String,
        @Param("vision") vision: String,
    )
}

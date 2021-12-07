package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameProjectDocumentationRepository : JpaRepository<GameProjectDocumentationEntity, Int>

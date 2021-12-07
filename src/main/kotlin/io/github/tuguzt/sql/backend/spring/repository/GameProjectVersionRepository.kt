package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectVersionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameProjectVersionRepository : JpaRepository<GameProjectVersionEntity, Int>

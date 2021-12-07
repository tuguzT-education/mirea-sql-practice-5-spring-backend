package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectPlatformEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameProjectPlatformRepository : JpaRepository<GameProjectPlatformEntity, Int>

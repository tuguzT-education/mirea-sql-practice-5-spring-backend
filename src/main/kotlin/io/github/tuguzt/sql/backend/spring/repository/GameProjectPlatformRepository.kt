package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectPlatformEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface GameProjectPlatformRepository : JpaRepository<GameProjectPlatformEntity, Int> {
    @Transactional
    @Modifying
    @Query("""update GameProjectPlatformEntity as gp set gp.name = :name where gp.id = :id""")
    fun update(@Param("id") id: Int, @Param("name") name: String)
}

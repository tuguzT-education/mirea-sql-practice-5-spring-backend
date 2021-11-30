package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface GameAssetTypeRepository : JpaRepository<GameAssetTypeEntity, Int> {
    @Transactional
    @Modifying
    @Query("""update GameAssetTypeEntity as ga set ga.name = :name where ga.id = :id""")
    fun update(@Param("id") id: Int, @Param("name") name: String)
}

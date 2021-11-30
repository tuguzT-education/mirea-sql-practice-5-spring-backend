package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectVersionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface GameProjectVersionRepository : JpaRepository<GameProjectVersionEntity, Int> {
    @Transactional
    @Modifying
    @Query(
        """
            update GameProjectVersionEntity as gp
                set gp.hash = :hash,
                    gp.major = :major,
                    gp.minor = :minor,
                    gp.patch = :patch,
                    gp.metadata = :metadata
                where gp.id = :id
        """
    )
    fun update(
        @Param("id") id: Int,
        @Param("hash") hash: String,
        @Param("major") major: Int,
        @Param("minor") minor: Int,
        @Param("patch") patch: Int,
        @Param("metadata") metadata: String,
    )
}

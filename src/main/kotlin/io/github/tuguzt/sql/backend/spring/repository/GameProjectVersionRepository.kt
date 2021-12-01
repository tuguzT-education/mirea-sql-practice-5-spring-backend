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
            update game_project_version as gp
                set gp.game_project_version_hash = :hash,
                    gp.game_project_version_major = :major,
                    gp.game_project_version_minor = :minor,
                    gp.game_project_version_patch = :patch,
                    gp.game_project_version_metadata = :metadata,
                    gp.game_project_id = :gameProjectId
                where gp.game_project_version_id = :id
        """,
        nativeQuery = true,
    )
    fun update(
        @Param("id") id: Int,
        @Param("hash") hash: String,
        @Param("major") major: Int,
        @Param("minor") minor: Int,
        @Param("patch") patch: Int,
        @Param("metadata") metadata: String,
        @Param("gameProjectId") gameProjectId: Int,
    )
}

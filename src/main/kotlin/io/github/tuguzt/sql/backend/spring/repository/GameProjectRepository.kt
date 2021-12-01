package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameProjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface GameProjectRepository : JpaRepository<GameProjectEntity, Int> {
    @Query("""select gp from GameProjectEntity as gp where gp.name = :name""")
    fun findByName(@Param("name") name: String): GameProjectEntity?

    @Transactional
    @Modifying
    @Query(
        """
            update game_project as gp
            set gp.game_project_name = :name,
                gp.game_project_description = :description,
                gp.game_project_documentation_id = :documentationId
            where gp.game_project_id = :id
        """,
        nativeQuery = true,
    )
    fun update(
        @Param("id") id: Int,
        @Param("name") name: String,
        @Param("description") description: String,
        @Param("documentationId") documentationId: Int,
    )

    @Transactional
    @Modifying
    @Query(
        """
            insert into game_project (
                game_project_name,
                game_project_description,
                game_project_documentation_id
            ) values (:name, :description, :documentationId)
        """,
        nativeQuery = true,
    )
    fun rawInsert(
        @Param("name") name: String,
        @Param("description") description: String,
        @Param("documentationId") documentationId: Int,
    )
}

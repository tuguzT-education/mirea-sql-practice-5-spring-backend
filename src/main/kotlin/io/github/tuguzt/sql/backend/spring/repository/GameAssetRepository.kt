package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameAssetEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface GameAssetRepository : JpaRepository<GameAssetEntity, Int> {
    @Query("""select ga from GameAssetEntity as ga where ga.name = :name""")
    fun findByName(@Param("name") name: String): GameAssetEntity?

    @Transactional
    @Modifying
    @Query(
        """
            update game_asset as ga
            set ga.game_asset_name = :name,
                ga.game_asset_description = :description,
                ga.game_asset_data_uri = :dataUri,
                ga.game_asset_type_id = :typeId,
                ga.game_project_id = :gameProjectId
            where ga.game_asset_id = :id
        """,
        nativeQuery = true,
    )
    fun update(
        @Param("id") id: Int,
        @Param("name") name: String,
        @Param("description") description: String,
        @Param("dataUri") dataUri: String,
        @Param("typeId") typeId: Int,
        @Param("gameProjectId") gameProjectId: Int,
    )

    @Transactional
    @Modifying
    @Query(
        """
            insert into game_asset (
                game_asset_name,
                game_asset_description,
                game_asset_data_uri,
                game_asset_type_id,
                game_project_id
            ) values (:name, :description, :dataUri, :typeId, :gameProjectId)
        """,
        nativeQuery = true,
    )
    fun rawInsert(
        @Param("name") name: String,
        @Param("description") description: String,
        @Param("dataUri") dataUri: String,
        @Param("typeId") typeId: Int,
        @Param("gameProjectId") gameProjectId: Int,
    )
}

package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import io.github.tuguzt.sql.backend.spring.service.GameAssetTypeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game_asset_types")
class GameAssetTypeController(override val service: GameAssetTypeService) : EntityController<GameAssetTypeEntity, Int> {
    @GetMapping("all")
    override suspend fun getAll() = super.getAll()

    @PostMapping("save")
    override suspend fun save(@RequestBody entity: GameAssetTypeEntity) = super.save(entity)

    @DeleteMapping("delete")
    override suspend fun delete(@RequestBody entity: GameAssetTypeEntity) = super.delete(entity)

    @GetMapping("find/id")
    override suspend fun findById(@RequestBody id: Int) = super.findById(id)

    @DeleteMapping("delete/id")
    override suspend fun deleteById(@RequestBody id: Int) = super.deleteById(id)
}

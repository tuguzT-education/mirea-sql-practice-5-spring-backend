package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import io.github.tuguzt.sql.backend.spring.service.GameAssetTypeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game_asset_types")
class GameAssetTypeController(private val service: GameAssetTypeService) {
    @GetMapping("all")
    suspend fun all() = service.getAll()

    @PostMapping("save")
    suspend fun save(@RequestBody gameAssetType: GameAssetTypeEntity) = service.save(gameAssetType)

    @DeleteMapping("delete")
    suspend fun delete(@RequestBody gameAssetType: GameAssetTypeEntity) = service.delete(gameAssetType)

    @GetMapping("find/id")
    suspend fun findById(@RequestBody id: Int) = service.findById(id)

    @DeleteMapping("delete/id")
    suspend fun deleteById(@RequestBody id: Int) = service.deleteById(id)
}

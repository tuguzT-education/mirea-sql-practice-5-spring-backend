package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.GameAssetEntity
import io.github.tuguzt.sql.backend.spring.service.GameAssetService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game_assets")
class GameAssetController(private val service: GameAssetService) {
    @GetMapping("all")
    suspend fun all() = service.getAll()

    @PostMapping("save")
    suspend fun save(@RequestBody gameAsset: GameAssetEntity) = service.save(gameAsset)

    @DeleteMapping("delete")
    suspend fun delete(@RequestBody gameAsset: GameAssetEntity) = service.delete(gameAsset)

    @GetMapping("find/id")
    suspend fun findById(@RequestBody id: Int) = service.findById(id)

    @DeleteMapping("delete/id")
    suspend fun deleteById(@RequestBody id: Int) = service.deleteById(id)
}

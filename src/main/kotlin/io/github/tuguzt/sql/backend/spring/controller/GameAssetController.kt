package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.GameAssetEntity
import io.github.tuguzt.sql.backend.spring.service.GameAssetService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game_assets")
class GameAssetController(override val service: GameAssetService) : EntityController<GameAssetEntity, Int> {
    @GetMapping("all")
    override suspend fun getAll() = super.getAll()

    @PostMapping("save")
    override suspend fun save(@RequestBody entity: GameAssetEntity) = super.save(entity)

    @DeleteMapping("delete")
    override suspend fun delete(@RequestBody entity: GameAssetEntity) = super.delete(entity)

    @GetMapping("find/id")
    override suspend fun findById(@RequestBody id: Int) = super.findById(id)

    @DeleteMapping("delete/id")
    override suspend fun deleteById(@RequestBody id: Int) = super.deleteById(id)
}

package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.GameProjectPlatformEntity
import io.github.tuguzt.sql.backend.spring.service.GameProjectPlatformService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game_project_platforms")
class GameProjectPlatformController(override val service: GameProjectPlatformService) :
    EntityController<GameProjectPlatformEntity, Int> {

    @GetMapping("all")
    override suspend fun getAll() = super.getAll()

    @PostMapping("insert")
    override suspend fun insert(entity: GameProjectPlatformEntity) = super.insert(entity)

    @PutMapping("update")
    override suspend fun update(entity: GameProjectPlatformEntity) = super.update(entity)

    @DeleteMapping("delete")
    override suspend fun delete(entity: GameProjectPlatformEntity) = super.delete(entity)

    @GetMapping("find/id")
    override suspend fun findById(id: Int) = super.findById(id)

    @DeleteMapping("delete/id")
    override suspend fun deleteById(id: Int) = super.deleteById(id)
}

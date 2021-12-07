package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.GameProjectEntity
import io.github.tuguzt.sql.backend.spring.service.GameProjectService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game_projects")
class GameProjectController(override val service: GameProjectService) : EntityController<GameProjectEntity, Int> {
    @GetMapping("all")
    override suspend fun getAll() = super.getAll()

    @PostMapping("save")
    override suspend fun save(@RequestBody entity: GameProjectEntity) = super.save(entity)

    @DeleteMapping("delete")
    override suspend fun delete(@RequestBody entity: GameProjectEntity) = super.delete(entity)

    @GetMapping("find/id")
    override suspend fun findById(id: Int) = super.findById(id)

    @DeleteMapping("delete/id")
    override suspend fun deleteById(id: Int) = super.deleteById(id)
}

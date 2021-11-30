package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.GameProjectVersionEntity
import io.github.tuguzt.sql.backend.spring.service.GameProjectVersionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game_project_versions")
class GameProjectVersionController(override val service: GameProjectVersionService) :
    EntityController<GameProjectVersionEntity, Int> {

    @GetMapping("all")
    override suspend fun getAll() = super.getAll()

    @PostMapping("insert")
    override suspend fun insert(@RequestBody entity: GameProjectVersionEntity) = super.insert(entity)

    @PutMapping("update")
    override suspend fun update(@RequestBody entity: GameProjectVersionEntity) = super.update(entity)

    @DeleteMapping("delete")
    override suspend fun delete(@RequestBody entity: GameProjectVersionEntity) = super.delete(entity)

    @GetMapping("find/id")
    override suspend fun findById(id: Int) = super.findById(id)

    @DeleteMapping("delete/id")
    override suspend fun deleteById(id: Int) = super.deleteById(id)
}

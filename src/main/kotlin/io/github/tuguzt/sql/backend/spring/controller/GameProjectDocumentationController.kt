package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import io.github.tuguzt.sql.backend.spring.service.GameProjectDocumentationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game_project_documentations")
class GameProjectDocumentationController(
    override val service: GameProjectDocumentationService,
) : EntityController<GameProjectDocumentationEntity, Int> {

    @GetMapping("all")
    override suspend fun getAll() = super.getAll()

    @PostMapping("insert")
    override suspend fun insert(@RequestBody entity: GameProjectDocumentationEntity) = super.insert(entity)

    @PutMapping("update")
    override suspend fun update(@RequestBody entity: GameProjectDocumentationEntity) = super.update(entity)

    @DeleteMapping("delete")
    override suspend fun delete(@RequestBody entity: GameProjectDocumentationEntity) = super.delete(entity)

    @GetMapping("find/id")
    override suspend fun findById(@RequestBody id: Int) = super.findById(id)

    @DeleteMapping("delete/id")
    override suspend fun deleteById(@RequestBody id: Int) = super.deleteById(id)
}

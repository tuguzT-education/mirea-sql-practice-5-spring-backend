package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import io.github.tuguzt.sql.backend.spring.service.GameProjectDocumentationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game_project_documentations")
class GameProjectDocumentationController(override val service: GameProjectDocumentationService) :
    EntityController<GameProjectDocumentationEntity, Int> {

    @GetMapping("all")
    override suspend fun getAll() = super.getAll()

    @PostMapping("save")
    override suspend fun save(@RequestBody entity: GameProjectDocumentationEntity) = super.save(entity)

    @DeleteMapping("delete")
    override suspend fun delete(@RequestBody entity: GameProjectDocumentationEntity) = super.delete(entity)

    @GetMapping("find/id")
    override suspend fun findById(@RequestBody id: Int) = super.findById(id)

    @DeleteMapping("delete/id")
    override suspend fun deleteById(@RequestBody id: Int) = super.deleteById(id)
}

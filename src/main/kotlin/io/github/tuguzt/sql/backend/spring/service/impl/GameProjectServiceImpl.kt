package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.GameProjectEntity
import io.github.tuguzt.sql.backend.spring.repository.GameProjectRepository
import io.github.tuguzt.sql.backend.spring.service.GameProjectService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class GameProjectServiceImpl(private val repository: GameProjectRepository) : GameProjectService {
    override suspend fun getAll() = withContext(Dispatchers.IO) { repository.findAll().toSet() }

    @Transactional
    override suspend fun save(entity: GameProjectEntity) = withContext(Dispatchers.IO) { repository.save(entity) }

    override suspend fun delete(entity: GameProjectEntity) = withContext(Dispatchers.IO) { repository.delete(entity) }

    override suspend fun findById(id: Int) = withContext(Dispatchers.IO) { repository.findByIdOrNull(id) }

    override suspend fun deleteById(id: Int) = withContext(Dispatchers.IO) { repository.deleteById(id) }

    override suspend fun exists(entity: GameProjectEntity) =
        withContext(Dispatchers.IO) { repository.existsById(entity.id) }
}

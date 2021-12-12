package io.github.tuguzt.sql.backend.spring.service.impl

import io.github.tuguzt.sql.backend.spring.model.UserEntity
import io.github.tuguzt.sql.backend.spring.repository.UserRepository
import io.github.tuguzt.sql.backend.spring.service.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val repository: UserRepository) : UserService {
    override suspend fun getAll() = withContext(Dispatchers.IO) { repository.findAll().toSet() }

    override suspend fun save(entity: UserEntity) = withContext(Dispatchers.IO) { repository.save(entity) }

    override suspend fun delete(entity: UserEntity) = withContext(Dispatchers.IO) { repository.delete(entity) }

    override suspend fun findById(id: Int) = withContext(Dispatchers.IO) { repository.findByIdOrNull(id) }

    override suspend fun deleteById(id: Int) = withContext(Dispatchers.IO) { repository.deleteById(id) }

    override suspend fun exists(entity: UserEntity) = withContext(Dispatchers.IO) { repository.existsById(entity.id) }

    override suspend fun findByLogin(login: String) = withContext(Dispatchers.IO) { repository.findByLogin(login) }
}

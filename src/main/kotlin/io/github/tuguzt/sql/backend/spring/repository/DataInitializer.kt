package io.github.tuguzt.sql.backend.spring.repository

import io.github.tuguzt.sql.backend.spring.model.GameAssetTypeEntity
import io.github.tuguzt.sql.backend.spring.model.GameProjectDocumentationEntity
import io.github.tuguzt.sql.backend.spring.model.GameProjectPlatformEntity
import io.github.tuguzt.sql.backend.spring.model.UserEntity
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val gameAssetTypeRepository: GameAssetTypeRepository,
    private val gameProjectPlatformRepository: GameProjectPlatformRepository,
    private val gameProjectDocumentationRepository: GameProjectDocumentationRepository,
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val gameAssetTypes = listOf(
            GameAssetTypeEntity(name = "Texture"),
            GameAssetTypeEntity(name = "Material"),
            GameAssetTypeEntity(name = "Level"),
        )
        gameAssetTypeRepository.saveAll(gameAssetTypes)

        val gameProjectPlatforms = listOf(
            GameProjectPlatformEntity(name = "Windows"),
            GameProjectPlatformEntity(name = "Linux"),
            GameProjectPlatformEntity(name = "macOS"),
            GameProjectPlatformEntity(name = "Android"),
            GameProjectPlatformEntity(name = "iOS"),
        )
        gameProjectPlatformRepository.saveAll(gameProjectPlatforms)

        val gameProjectDocumentations = listOf(
            GameProjectDocumentationEntity(businessPlan = "idk", designDocument = "idk", vision = "idk")
        )
        gameProjectDocumentationRepository.saveAll(gameProjectDocumentations)

        val user = UserEntity(
            login = "tuguzT",
            passwordEncrypted = passwordEncoder.encode("tugushev_timur"),
        )
        userRepository.save(user)
    }
}

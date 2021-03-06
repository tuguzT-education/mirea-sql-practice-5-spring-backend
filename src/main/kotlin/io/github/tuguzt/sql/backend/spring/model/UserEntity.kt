package io.github.tuguzt.sql.backend.spring.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tuguzt.sql.domain.model.User
import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@Entity
@Table(name = "\"user\"")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    override val id: Int = 0,

    @Column(name = "user_login", length = 20, unique = true)
    override var login: String,

    @JsonProperty("password_encrypted")
    @Column(name = "user_password_encrypted", length = 100)
    override var passwordEncrypted: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "officer_id", referencedColumnName = "officer_id")
    override var officer: OfficerEntity? = null,
) : User {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as UserEntity
        return this.id == other.id
    }

    override fun hashCode() = javaClass.hashCode()
}

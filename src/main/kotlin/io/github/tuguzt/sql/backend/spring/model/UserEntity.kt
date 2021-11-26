package io.github.tuguzt.sql.backend.spring.model

import io.github.tuguzt.sql.domain.model.User
import javax.persistence.*

@Entity
@Table(name = "\"user\"")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Int,

    @Column(name = "user_login", length = 20)
    override val login: String,

    @Column(name = "user_password_encrypted", length = 100)
    override val passwordEncrypted: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "officer_id", referencedColumnName = "officer_id")
    override val officer: OfficerEntity?,
) : User

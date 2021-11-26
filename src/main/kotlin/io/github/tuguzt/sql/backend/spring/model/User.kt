package io.github.tuguzt.sql.backend.spring.model

import javax.persistence.*

@Entity
@Table(name = "\"user\"")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Int,

    @Column(name = "user_login", length = 20)
    val login: String,

    @Column(name = "user_password_encrypted", length = 100)
    val passwordEncrypted: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "officer_id", referencedColumnName = "officer_id")
    val officer: Officer?,
)

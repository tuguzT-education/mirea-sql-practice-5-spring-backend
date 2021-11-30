package io.github.tuguzt.sql.backend.spring

import java.util.Optional

/**
 * Convert [Optional] to Kotlin nullable type of [T].
 */
fun <T> Optional<T>.orNull(): T? = orElse(null)

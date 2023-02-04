package com.deep.model

import ch.qos.logback.core.subst.Token

data class User(
    val id: Int,
    val fullName: String,
    val avatar: String,
    val email: String,
    val authToken: String? = null,
    val createdAt: String
)

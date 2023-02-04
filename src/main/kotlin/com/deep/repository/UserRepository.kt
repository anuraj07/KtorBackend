package com.deep.repository

import com.deep.service.CreateUserParams

interface UserRepository {
    suspend fun registerUser(params: CreateUserParams)
    suspend fun loginUser(email: String, password: String)
}
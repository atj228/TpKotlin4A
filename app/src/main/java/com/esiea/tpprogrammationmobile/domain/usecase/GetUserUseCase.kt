package com.esiea.tpprogrammationmobile.domain.usecase

import com.esiea.tpprogrammationmobile.data.repository.UserRepository
import com.esiea.tpprogrammationmobile.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
){
    suspend fun invoke(email: String) : User{
       return userRepository.getUser(email)
    }
}
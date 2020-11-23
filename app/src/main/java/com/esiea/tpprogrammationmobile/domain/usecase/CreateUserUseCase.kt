package com.esiea.tpprogrammationmobile.domain.usecase

import com.esiea.tpprogrammationmobile.data.repository.UserRepository
import com.esiea.tpprogrammationmobile.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}
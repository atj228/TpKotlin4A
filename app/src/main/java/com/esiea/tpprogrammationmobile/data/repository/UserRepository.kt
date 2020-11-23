package com.esiea.tpprogrammationmobile.data.repository

import com.esiea.tpprogrammationmobile.data.local.DatabaseDao
import com.esiea.tpprogrammationmobile.data.local.models.toData
import com.esiea.tpprogrammationmobile.data.local.models.toEntity
import com.esiea.tpprogrammationmobile.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
){
    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User {
        val userLocal = databaseDao.findByName(email)
        return userLocal.toEntity()
    }
}
package com.esiea.tpprogrammationmobile.Injection

import android.content.Context
import androidx.room.Room
import com.esiea.tpprogrammationmobile.data.local.AppDatabase
import com.esiea.tpprogrammationmobile.data.local.DatabaseDao
import com.esiea.tpprogrammationmobile.data.repository.UserRepository
import com.esiea.tpprogrammationmobile.domain.usecase.CreateUserUseCase
import com.esiea.tpprogrammationmobile.domain.usecase.GetUserUseCase
import com.esiea.tpprogrammationmobile.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import java.security.AccessControlContext

val presentationModule = module {
    factory { MainViewModel(get(), get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}
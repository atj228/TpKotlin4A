package com.esiea.tpprogrammationmobile.Injection

import com.esiea.tpprogrammationmobile.MainViewModel
import org.koin.dsl.module

// just declare it
val presentationModule = module{
    factory { MainViewModel() }
}
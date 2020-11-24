package com.esiea.tpprogrammationmobile.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()
object LoginError : LoginStatus()
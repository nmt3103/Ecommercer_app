package com.example.ecommercer_app.util

sealed class RegisterValidation(){
    object Success : RegisterValidation()
    data class Failded(val message : String) : RegisterValidation()
}

data class RegisterFieldState(
    val email: RegisterValidation,
    val password: RegisterValidation
)
package com.example.ecommercer_app.util

import android.util.Patterns
import java.util.regex.Pattern

fun validateEmail(email : String) : RegisterValidation{
    if (email.isEmpty())
        return RegisterValidation.Failded("Email cannot be empty")
    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return RegisterValidation.Failded("Wrong email format")

    return RegisterValidation.Success
}

fun validatePassword(password : String) : RegisterValidation{
    if (password.isEmpty())
        return RegisterValidation.Failded("Password cannot be empty")

    if (password.length < 6)
        return RegisterValidation.Failded("Password should contains 6 char")
    return RegisterValidation.Success
}
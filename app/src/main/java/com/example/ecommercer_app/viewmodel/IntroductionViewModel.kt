package com.example.ecommercer_app.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercer_app.R
import com.example.ecommercer_app.util.Constants
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroductionViewModel @Inject constructor(
    private val sharePreferences : SharedPreferences,
    private val firebaseAuth : FirebaseAuth
) : ViewModel() {

    private val _navigate = MutableStateFlow(0)
    val navigate : StateFlow<Int> = _navigate

    companion object{
        const val SHOPPING_ACTIVITY =23
        const val ACCOUNT_OPTIONS_FRAGMENT = R.id.action_introductionFragment_to_accountOptionsFragment
    }


    init {
        val isButtonClicked = sharePreferences.getBoolean(Constants.INTRODUCTION_KEY,false)
        val user = firebaseAuth.currentUser

        if (user != null){

            viewModelScope.launch {
                _navigate.emit(SHOPPING_ACTIVITY)
            }

        }else if(isButtonClicked){
            viewModelScope.launch {
                _navigate.emit(ACCOUNT_OPTIONS_FRAGMENT)
            }
        } else {
            Unit
        }

    }

    fun startButtonClick(){
        sharePreferences.edit().putBoolean(Constants.INTRODUCTION_KEY,true).apply()
    }
}
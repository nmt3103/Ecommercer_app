package com.example.ecommercer_app.util

import android.view.View
import androidx.fragment.app.Fragment
import com.example.ecommercer_app.R
import com.example.ecommercer_app.activities.ShoppingActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

fun Fragment.hideBottomNavigationView(){
    val bottomNav = (activity as ShoppingActivity).findViewById<BottomNavigationView>(
        R.id.bottomNavigation
    )
    bottomNav.visibility = View.GONE
}

fun Fragment.showBottomNavigationView(){
    val bottomNav = (activity as ShoppingActivity).findViewById<BottomNavigationView>(
        R.id.bottomNavigation
    )
    bottomNav.visibility = View.VISIBLE
}
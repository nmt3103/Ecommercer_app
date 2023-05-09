package com.example.ecommercer_app.di


import android.app.Application
import android.content.Context
import com.example.ecommercer_app.firebase.FirebaseCommon
import com.example.ecommercer_app.util.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object AppModule {
    @Provides
    @Singleton
    fun providerFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun  provideFirebaseFirestoreDatabase() = Firebase.firestore


    @Provides
    fun provideeIntroductionSP(
        application : Application
    ) = application.getSharedPreferences(Constants.INTRODUCTION_SP, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideFirebaseCommon(
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore
    ) = FirebaseCommon(firestore,firebaseAuth)

    @Provides
    @Singleton
    fun provideStorage() = FirebaseStorage.getInstance().reference
}
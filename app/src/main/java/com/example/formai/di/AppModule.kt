package com.example.formai.di

import com.example.formai.domain.repository.AuthRepository
import com.example.formai.domain.repository.AuthRepositoryImpl
import com.example.formai.domain.viewmodel.InputViewModel
import com.example.formai.domain.viewmodel.PoseLandmarkViewModel
import com.example.formai.ui.screens.workout.PoseLandmarkerHelper
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }

    @Provides
    @Singleton
    fun providePoseLandmarkListener(): PoseLandmarkerHelper.LandmarkerListener = PoseLandmarkViewModel()

    @Provides
    @Singleton
    fun provideInputViewModel(): InputViewModel = InputViewModel()
}
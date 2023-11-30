package com.example.trainingtoday.di

import com.example.trainingtoday.data.remote.TrainingRepositoryImpl
import com.example.trainingtoday.domain.repository.TrainingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTrainingRepository(
        trainingRepository: TrainingRepositoryImpl
    ): TrainingRepository
}
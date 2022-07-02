package com.drsync.tourismapp.core.di

import android.content.Context

import com.drsync.tourismapp.core.data.source.local.LocalDataSource
import com.drsync.tourismapp.core.data.source.local.room.TourismDatabase

import com.drsync.tourismapp.core.data.TourismRepository
import com.drsync.tourismapp.core.data.source.remote.RemoteDataSource
import com.drsync.tourismapp.core.domain.repository.ITourismRepository
import com.drsync.tourismapp.core.domain.usecase.TourismInteractor
import com.drsync.tourismapp.core.domain.usecase.TourismUseCase
import com.drsync.tourismapp.core.utils.AppExecutors
import com.drsync.tourismapp.core.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}

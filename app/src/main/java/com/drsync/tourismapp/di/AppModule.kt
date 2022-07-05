package com.drsync.tourismapp.di

import com.drsync.tourismapp.core.domain.usecase.TourismInteractor
import com.drsync.tourismapp.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}
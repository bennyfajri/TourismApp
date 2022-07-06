package com.drsync.tourismapp.di

import com.drsync.tourismapp.core.domain.usecase.TourismInteractor
import com.drsync.tourismapp.core.domain.usecase.TourismUseCase
import com.drsync.tourismapp.detail.DetailTourismViewModel
import com.drsync.tourismapp.favorite.FavoriteViewModel
import com.drsync.tourismapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}
package com.drsync.tourismapp.map

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val mapsModule = module {
    viewModel { MapsViewModel(get()) }
}
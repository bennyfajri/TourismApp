package com.drsync.tourismapp.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.drsync.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())
}


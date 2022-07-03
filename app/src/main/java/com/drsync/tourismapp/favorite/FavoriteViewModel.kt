package com.drsync.tourismapp.favorite

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.drsync.tourismapp.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getFavoriteTourism())

}


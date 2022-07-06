package com.drsync.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.drsync.tourismapp.core.domain.model.Tourism
import com.drsync.tourismapp.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(
    private val tourismUseCase: TourismUseCase
) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}


package com.drsync.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.drsync.tourismapp.core.domain.model.Tourism
import com.drsync.tourismapp.core.domain.usecase.TourismUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailTourismViewModel @Inject constructor(
    private val tourismUseCase: TourismUseCase
) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}


package com.drsync.tourismapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.drsync.tourismapp.core.data.Resource
import com.drsync.tourismapp.core.domain.model.Tourism
import com.drsync.tourismapp.core.domain.repository.ITourismRepository

class TourismInteractor(
    private val tourismRepository: ITourismRepository
): TourismUseCase {
    override fun getAllTourism(): LiveData<Resource<List<Tourism>>> = tourismRepository.getAllTourism()

    override fun getFavoriteTourism(): LiveData<List<Tourism>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        return tourismRepository.setFavoriteTourism(tourism, state)
    }
}
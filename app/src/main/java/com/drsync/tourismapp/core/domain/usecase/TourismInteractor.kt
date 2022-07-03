package com.drsync.tourismapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.drsync.tourismapp.core.data.Resource
import com.drsync.tourismapp.core.domain.model.Tourism
import com.drsync.tourismapp.core.domain.repository.ITourismRepository
import io.reactivex.Flowable

class TourismInteractor(
    private val tourismRepository: ITourismRepository
): TourismUseCase {
    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)
}
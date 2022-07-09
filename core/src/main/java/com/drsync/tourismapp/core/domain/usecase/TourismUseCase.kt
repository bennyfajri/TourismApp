package com.drsync.tourismapp.core.domain.usecase

import com.drsync.tourismapp.core.data.Resource
import com.drsync.tourismapp.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}
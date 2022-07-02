package com.drsync.tourismapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.drsync.tourismapp.core.data.Resource
import com.drsync.tourismapp.core.domain.model.Tourism

interface ITourismRepository {

    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}
package com.drsync.tourismapp.core.data

import com.drsync.tourismapp.core.data.source.local.LocalDataSource
import com.drsync.tourismapp.core.data.source.remote.RemoteDataSource
import com.drsync.tourismapp.core.data.source.remote.network.ApiResponse
import com.drsync.tourismapp.core.data.source.remote.response.TourismResponse
import com.drsync.tourismapp.core.domain.model.Tourism
import com.drsync.tourismapp.core.domain.repository.ITourismRepository
import com.drsync.tourismapp.core.utils.AppExecutors
import com.drsync.tourismapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TourismRepository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITourismRepository {

//    companion object {
//        @Volatile
//        private var instance: TourismRepository? = null
//
//        fun getInstance(
//            remoteData: RemoteDataSource,
//            localData: LocalDataSource,
//            appExecutors: AppExecutors
//        ): TourismRepository =
//            instance ?: synchronized(this) {
//                instance ?: TourismRepository(remoteData, localData, appExecutors)
//            }
//    }

    override fun getAllTourism(): Flow<com.drsync.tourismapp.core.data.Resource<List<Tourism>>> =
        object : com.drsync.tourismapp.core.data.NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data == null || data.isEmpty()
//                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}


package com.drsync.tourismapp.core.data

import com.drsync.tourismapp.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<com.drsync.tourismapp.core.data.Resource<ResultType>> = flow {
        emit(com.drsync.tourismapp.core.data.Resource.Loading())
        val dbSource = loadFromDB().first()
        if(shouldFetch(dbSource)){
            emit(com.drsync.tourismapp.core.data.Resource.Loading())
            when (val apiResponse = createCall().first()){
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map { com.drsync.tourismapp.core.data.Resource.Success(it) })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map { com.drsync.tourismapp.core.data.Resource.Success(it) })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(com.drsync.tourismapp.core.data.Resource.Error<ResultType>(apiResponse.errorMessage))
                }
            }
        }else{
            emitAll(loadFromDB().map { com.drsync.tourismapp.core.data.Resource.Success(it) })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<com.drsync.tourismapp.core.data.Resource<ResultType>> = result
}
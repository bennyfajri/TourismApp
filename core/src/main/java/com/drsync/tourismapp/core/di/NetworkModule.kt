package com.drsync.tourismapp.core.di

//@Module
//@InstallIn(SingletonComponent::class)
//class NetworkModule {
//
//    @Provides
//    fun provideOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//            .connectTimeout(120, TimeUnit.SECONDS)
//            .readTimeout(120, TimeUnit.SECONDS)
//            .build()
//    }
//
//    @Provides
//    fun provideApiService(client: OkHttpClient): ApiService {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://tourism-api.dicoding.dev/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//        return retrofit.create(ApiService::class.java)
//    }
//}
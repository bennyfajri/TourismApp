package com.drsync.tourismapp.di

import com.drsync.tourismapp.core.di.CoreComponent
import com.drsync.tourismapp.detail.DetailTourismActivity
import com.drsync.tourismapp.favorite.FavoriteFragment
import com.drsync.tourismapp.home.HomeFragment
import dagger.Component


@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}
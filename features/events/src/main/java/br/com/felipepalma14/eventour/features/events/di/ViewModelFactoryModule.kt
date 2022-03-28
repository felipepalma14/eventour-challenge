package br.com.felipepalma14.eventour.features.events.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.felipepalma14.commons.factory.ViewModelFactory
import br.com.felipepalma14.commons.factory.ViewModelKey
import br.com.felipepalma14.eventour.features.events.home.presentation.EventListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {

    @Binds
    @Singleton
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(EventListViewModel::class)
    abstract fun bindMainActivityViewModel(mainViewModel: EventListViewModel): ViewModel
}
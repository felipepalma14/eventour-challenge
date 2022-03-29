package br.com.felipepalma14.eventour.features.events.home.di

import androidx.lifecycle.ViewModel
import br.com.felipepalma14.commons.base.ViewModelKey
import br.com.felipepalma14.commons.scopes.ActivityScope
import br.com.felipepalma14.eventour.features.events.home.data.EventListRepository
import br.com.felipepalma14.eventour.features.events.home.data.IEventListRepository
import br.com.felipepalma14.eventour.features.events.home.domain.EventListInteractor
import br.com.felipepalma14.eventour.features.events.home.domain.IEventListInteractor
import br.com.felipepalma14.eventour.features.events.home.presentation.EventListFragment
import br.com.felipepalma14.eventour.features.events.home.presentation.EventListViewModel
import br.com.felipepalma14.eventour.features.events.home.presentation.EventourHomeActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class EventourHomeModuleBuilder {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            EventourHomeModule::class,
        ]
    )
    internal abstract fun bindEventourHomeActivity(): EventourHomeActivity
}

@Module
interface EventourHomeModule {
    @Binds
    fun bindEventListRepository(
        repository: EventListRepository
    ): IEventListRepository

    @Binds
    fun bindEventListInteractor(
        interactor: EventListInteractor
    ): IEventListInteractor

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(EventListViewModel::class)
    fun bindEventListViewModel(vm: EventListViewModel): ViewModel
}
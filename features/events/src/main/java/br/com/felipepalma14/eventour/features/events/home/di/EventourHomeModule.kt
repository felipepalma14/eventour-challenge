package br.com.felipepalma14.eventour.features.events.home.di

import br.com.felipepalma14.commons.scopes.ActivityScope
import br.com.felipepalma14.eventour.features.events.di.ViewModelFactoryModule
import br.com.felipepalma14.eventour.features.events.home.presentation.EventListFragment
import br.com.felipepalma14.eventour.features.events.home.presentation.EventourHomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [( ViewModelFactoryModule::class)])
abstract class EventourHomeModuleBuilder {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            EventourHomeModule::class,
        ]
    )
    internal abstract fun bindEventourHomeActivity(): EventourHomeActivity

    @ContributesAndroidInjector
    internal abstract fun bindEventListFragment(): EventListFragment



}

@Module
abstract class EventourHomeModule {
}
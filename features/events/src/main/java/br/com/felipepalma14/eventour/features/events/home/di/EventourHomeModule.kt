package br.com.felipepalma14.eventour.features.events.home.di

import br.com.felipepalma14.eventour.features.events.home.presentation.EventourHomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

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
abstract class EventourHomeModule {
}
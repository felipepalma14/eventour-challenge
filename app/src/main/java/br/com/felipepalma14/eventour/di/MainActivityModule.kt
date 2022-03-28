package br.com.felipepalma14.eventour.di

import br.com.felipepalma14.eventour.MainActivity
import br.com.felipepalma14.eventour.features.events.home.di.ActivityScope
import br.com.felipepalma14.eventour.features.events.home.di.EventourHomeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            EventourHomeModule::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity
}
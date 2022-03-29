package br.com.felipepalma14.eventour.di

import android.app.Application
import br.com.felipepalma14.commons.base.ViewModelModule
import br.com.felipepalma14.eventour.EventourApplication
import br.com.felipepalma14.eventour.features.di.EventourModuleBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        MainActivityModule::class,
        EventourModuleBuilder::class,
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(application: EventourApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
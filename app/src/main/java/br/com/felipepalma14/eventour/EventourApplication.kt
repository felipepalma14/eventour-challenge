package br.com.felipepalma14.eventour

import br.com.felipepalma14.eventour.di.AppComponent
import br.com.felipepalma14.eventour.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class EventourApplication: DaggerApplication() {
    private lateinit var appComponent: AppComponent
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
        appComponent.inject(this)
        return appComponent
    }
}
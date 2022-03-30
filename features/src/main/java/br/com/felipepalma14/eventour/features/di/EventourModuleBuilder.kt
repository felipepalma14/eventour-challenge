package br.com.felipepalma14.eventour.features.di

import br.com.felipepalma14.eventour.features.events.details.di.EventourDetailsModuleBuilder
import br.com.felipepalma14.eventour.features.events.home.di.EventourHomeModuleBuilder
import br.com.felipepalma14.eventour.features.service.EventourService
import br.com.felipepalma14.eventour.features.service.IEventourService
import br.com.felipepalma14.eventour.features.service.model.EventourLogLevel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        EventourHomeModuleBuilder::class,
        EventourDetailsModuleBuilder::class
    ]
)
abstract class EventourModuleBuilder {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideEventourLogLevel(): EventourLogLevel = EventourLogLevel.ALL

        @JvmStatic
        @Provides
        @Singleton
        fun provideEventourService(
            logLevel: EventourLogLevel
        ): IEventourService = EventourService(
            logLevel
        )
    }


}
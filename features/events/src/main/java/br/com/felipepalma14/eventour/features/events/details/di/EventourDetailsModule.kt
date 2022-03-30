package br.com.felipepalma14.eventour.features.events.details.di

import androidx.lifecycle.ViewModel
import br.com.felipepalma14.commons.base.ViewModelKey
import br.com.felipepalma14.commons.scopes.ActivityScope
import br.com.felipepalma14.eventour.features.events.details.data.EventDetailsRepository
import br.com.felipepalma14.eventour.features.events.details.data.IEventDetailsRepository
import br.com.felipepalma14.eventour.features.events.details.domain.EventDataParams
import br.com.felipepalma14.eventour.features.events.details.domain.EventDetailsInteractor
import br.com.felipepalma14.eventour.features.events.details.domain.IEventDetailsInteractor
import br.com.felipepalma14.eventour.features.events.details.presentation.EventDetailsActivity
import br.com.felipepalma14.eventour.features.events.details.presentation.EventDetailsActivity.Companion.EVENT_ID
import br.com.felipepalma14.eventour.features.events.details.presentation.EventDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class EventourDetailsModuleBuilder {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            EventourDetailsModule::class,
        ]
    )
    internal abstract fun bindEventourDetailsActivity(): EventDetailsActivity

}

@Module
interface EventourDetailsModule {
    @Binds
    fun bindEventDetailsRepository(
        repository: EventDetailsRepository
    ): IEventDetailsRepository

    @Binds
    fun bindEventDetailsInteractor(
        interactor: EventDetailsInteractor
    ): IEventDetailsInteractor

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(EventDetailsViewModel::class)
    fun bindEventDetailsViewModel(vm: EventDetailsViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideEventDataParams(activity: EventDetailsActivity): EventDataParams =
            with(activity.intent?.extras) {
                val eventId = this?.getLong(EVENT_ID)
                EventDataParams(eventId)
            }
    }
}
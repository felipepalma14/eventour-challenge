package br.com.felipepalma14.eventour.features.events.details.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.felipepalma14.commons.base.BaseViewModel
import br.com.felipepalma14.commons.extensions.runOn
import br.com.felipepalma14.eventour.features.events.details.domain.EventDataParams
import br.com.felipepalma14.eventour.features.events.details.domain.IEventDetailsInteractor
import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.eventour.features.events.home.presentation.EventListAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class EventDetailsViewModelState {
    object OnError : EventDetailsViewModelState()
    object OnLoading : EventDetailsViewModelState()
    data class OnGetEventDetails(val eventData: EventData) : EventDetailsViewModelState()
}

sealed class EventDetailsAction {
    data class OnEventLocationClick(val eventData: EventData) : EventDetailsAction()
}

class EventDetailsViewModel @Inject constructor(
    private val interactor: IEventDetailsInteractor,
    private val eventDataParams: EventDataParams
) : BaseViewModel() {
    val state = MutableLiveData<EventDetailsViewModelState>()
    val action = MutableLiveData<EventDetailsAction>()
    private val _event = MutableLiveData<EventData>()
    val event: LiveData<EventData>
        get() = _event

    override fun onCreate() {
        viewModelScope.launch {
            state.value = EventDetailsViewModelState.OnLoading
            runOn(Dispatchers.IO) {
                interactor.getEventDetailsData(eventDataParams)
            }.onSuccess { eventData ->
                state.value = EventDetailsViewModelState.OnGetEventDetails(eventData)
                _event.value = eventData

            }.onFailure { exception ->
                Log.d("onFailure", "onCreate: $exception")
                state.value = EventDetailsViewModelState.OnError
            }
        }
    }

    fun onEventLocation() {
        action.value = event.value?.let { EventDetailsAction.OnEventLocationClick(it) }
    }
}
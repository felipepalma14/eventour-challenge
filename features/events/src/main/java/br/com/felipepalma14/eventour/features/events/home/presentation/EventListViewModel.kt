package br.com.felipepalma14.eventour.features.events.home.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.felipepalma14.commons.base.BaseViewModel
import br.com.felipepalma14.commons.extensions.runOn
import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.eventour.features.events.home.domain.IEventListInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class EventListViewModelState {
    data class OnGetEventList(val vo: List<EventData>) : EventListViewModelState()
    object OnGetEventEmptyList : EventListViewModelState()
    object OnError : EventListViewModelState()
    object OnLoading : EventListViewModelState()
}

class EventListViewModel @Inject constructor(
    private val interactor: IEventListInteractor,
) : BaseViewModel() {
    val state = MutableLiveData<EventListViewModelState>()

    override fun onCreate() {
        viewModelScope.launch {
            state.value = EventListViewModelState.OnLoading
            runOn(Dispatchers.IO) {
                interactor.getEventListData()
            }.onSuccess { eventList ->
                state.value = EventListViewModelState.OnGetEventEmptyList
//                if (eventList.isNotEmpty()) {
//                    state.value = EventListViewModelState.OnGetEventList(eventList)
//                } else {
//                    state.value = EventListViewModelState.OnGetEventEmptyList
//                }

            }.onFailure { exception ->
                Log.d("onFailure", "onCreate: $exception")
                state.value = EventListViewModelState.OnError
            }
        }
    }
}
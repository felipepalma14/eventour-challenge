package br.com.felipepalma14.eventour.features.events.home.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class EventListViewModel @Inject constructor(

) : ViewModel() {

    val empty = MutableLiveData(false)
}
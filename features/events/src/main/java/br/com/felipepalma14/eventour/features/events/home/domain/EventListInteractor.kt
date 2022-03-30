package br.com.felipepalma14.eventour.features.events.home.domain

import br.com.felipepalma14.eventour.features.events.domain.mapper.toEventData
import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.eventour.features.events.home.data.IEventListRepository
import javax.inject.Inject

interface IEventListInteractor {
    suspend fun getEventListData(): List<EventData>
}

class EventListInteractor @Inject constructor(
    private val repository: IEventListRepository
) : IEventListInteractor {

    override suspend fun getEventListData() = repository.getEventList().map { it.toEventData() }
}

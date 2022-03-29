package br.com.felipepalma14.eventour.features.events.home.domain

import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.eventour.features.events.home.data.IEventListRepository
import br.com.felipepalma14.eventour.features.service.model.EventResponse
import javax.inject.Inject

interface IEventListInteractor {
    suspend fun getEventListData(): List<EventData>
}

class EventListInteractor @Inject constructor(
    private val repository: IEventListRepository
): IEventListInteractor {

    override suspend fun getEventListData(): List<EventData> {
        return repository.getEventList().map { it.toEventData() }
    }
}

fun EventResponse.toEventData() = EventData(
    id, title, description, date, image,
    latitude, longitude, price
)
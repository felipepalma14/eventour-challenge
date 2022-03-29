package br.com.felipepalma14.eventour.features.events.home.data

import br.com.felipepalma14.eventour.features.service.IEventourService
import br.com.felipepalma14.eventour.features.service.model.EventResponse
import javax.inject.Inject

interface IEventListRepository {
    suspend fun getEventList(): List<EventResponse>
}
class EventListRepository @Inject constructor(
    private val service: IEventourService
): IEventListRepository {

    override suspend fun getEventList() = service.getEventList()

}
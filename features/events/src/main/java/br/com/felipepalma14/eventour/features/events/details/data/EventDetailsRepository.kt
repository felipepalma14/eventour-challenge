package br.com.felipepalma14.eventour.features.events.details.data

import br.com.felipepalma14.eventour.features.service.IEventourService
import br.com.felipepalma14.eventour.features.service.model.EventResponse
import javax.inject.Inject

interface IEventDetailsRepository {
    suspend fun getEventDetails(id :Long?): EventResponse
}
class EventDetailsRepository @Inject constructor(
    private val service: IEventourService
): IEventDetailsRepository {

    override suspend fun getEventDetails(id: Long?) = service.getEventDetail(id)

}
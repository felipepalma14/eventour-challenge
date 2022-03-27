package br.com.felipepalma14.eventour.features.service

import br.com.felipepalma14.eventour.features.service.api.ApiFactory
import br.com.felipepalma14.eventour.features.service.api.EventourAPIService
import br.com.felipepalma14.eventour.features.service.extension.responseBy
import br.com.felipepalma14.eventour.features.service.mapper.EventourMapper
import br.com.felipepalma14.eventour.features.service.model.EventResponse
import br.com.felipepalma14.eventour.features.service.model.EventourLogLevel

interface IEventourService {
    val eventourMapper: EventourMapper
    get() = EventourMapper()

    suspend fun getEventList(): List<EventResponse>
    suspend fun getEventDetail(id: Long): EventResponse
}
class EventourService(
    logLevel: EventourLogLevel,
    private val api: EventourAPIService = ApiFactory.createEventourApiService(logLevel)
): IEventourService {
    override suspend fun getEventList() =
        api.getEventList() responseBy eventourMapper

    override suspend fun getEventDetail(id: Long) =
        api.getEventDetail(id) responseBy eventourMapper

}
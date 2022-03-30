package br.com.felipepalma14.eventour.features.events.details.domain

import br.com.felipepalma14.eventour.features.events.details.data.IEventDetailsRepository
import br.com.felipepalma14.eventour.features.events.domain.mapper.toEventData
import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import javax.inject.Inject

interface IEventDetailsInteractor {
    suspend fun getEventDetailsData(eventDataParams: EventDataParams): EventData
}

class EventDetailsInteractor @Inject constructor(
    private val repository: IEventDetailsRepository
) : IEventDetailsInteractor {

    override suspend fun getEventDetailsData(eventDataParams: EventDataParams): EventData {
        return repository.getEventDetails(eventDataParams.eventId).toEventData()
    }
}

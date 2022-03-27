package br.com.felipepalma14.eventour.features.service.api

import br.com.felipepalma14.eventour.features.service.model.EventResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EventourAPIService {
    // https://5f5a8f24d44d640016169133.mockapi.io/api/events
    // https://5f5a8f24d44d640016169133.mockapi.io/api/events/1
    // https://5f5a8f24d44d640016169133.mockapi.io/api/checkin
    companion object {
        private const val GET_EVENT_LIST = "events"
        private const val GET_EVENT_DETAIL = "events/{id}"
        private const val POST_EVENT_CHECKIN = "checkin"
    }

    @GET(GET_EVENT_LIST)
    suspend fun getEventList(): Response<List<EventResponse>>

    @GET(GET_EVENT_LIST)
    suspend fun getEventDetail(@Path("id") id : Long): Response<EventResponse>

}
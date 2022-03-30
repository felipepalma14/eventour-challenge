package br.com.felipepalma14.eventour.features.service.mapper

import br.com.felipepalma14.eventour.features.service.model.EventourServiceException
import retrofit2.Response

class EventourMapper {
    fun <T> mapTo(response: Response<T>): T {
        val responseBody = response.body()
        if (responseBody != null) return responseBody
        else {
            throw EventourServiceException(
                response.code()
            )
        }
    }
}
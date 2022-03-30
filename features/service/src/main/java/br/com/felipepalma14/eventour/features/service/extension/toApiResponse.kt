package br.com.felipepalma14.eventour.features.service.extension

import br.com.felipepalma14.eventour.features.service.mapper.EventourMapper
import retrofit2.Response

internal infix fun <T> Response<T>.responseBy(eventourMapper: EventourMapper): T =
    eventourMapper.mapTo(this)
package br.com.felipepalma14.eventour.features.service.model

import java.lang.Exception

data class EventourServiceException(
    var statusCode: Int
) : Exception()
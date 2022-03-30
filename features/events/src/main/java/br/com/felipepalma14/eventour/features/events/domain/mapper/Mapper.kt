package br.com.felipepalma14.eventour.features.events.domain.mapper

import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.eventour.features.service.model.EventResponse

fun EventResponse.toEventData() = EventData(
    id = this.id,
    title = this.title,
    description = this.description,
    date = this.date,
    image = this.image,
    latitude = this.latitude,
    longitude = this.longitude,
    price = this.price
)
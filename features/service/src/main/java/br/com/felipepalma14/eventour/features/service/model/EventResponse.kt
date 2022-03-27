package br.com.felipepalma14.eventour.features.service.model


data class EventResponse(
    val id: Long,
    val title: String,
    val description: String,
    val date: Long,
    val image: String,
    val latitude: Long,
    val longitude: Long,
    val price: Double

)
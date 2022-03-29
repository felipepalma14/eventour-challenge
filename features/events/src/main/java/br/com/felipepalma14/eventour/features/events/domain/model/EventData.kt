package br.com.felipepalma14.eventour.features.events.domain.model

data class EventData(
    val id: Long,
    val title: String,
    val description: String,
    val date: Long = 0L,
    val image: String,
    val latitude: Double,
    val longitude: Double,
    val price: Double = 0.0,
)

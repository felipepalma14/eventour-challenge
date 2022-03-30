package br.com.felipepalma14.eventour.features.service

import br.com.felipepalma14.eventour.features.service.api.EventourAPIService
import br.com.felipepalma14.eventour.features.service.extension.responseBy
import br.com.felipepalma14.eventour.features.service.model.EventResponse
import br.com.felipepalma14.eventour.features.service.model.EventourLogLevel
import br.com.felipepalma14.testingbase.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class EventourServiceTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var service: IEventourService

    @Mock
    private lateinit var api: EventourAPIService

    @Before
    fun setup() {
        service = EventourService(
            EventourLogLevel.ALL,
            api
        )
    }

    @Test
    fun getEventList() {
        // given
        val response = Response.success(
            listOf(
                EventResponse(
                    10L, "title", "description", 29292929292, "image",
                    10000.0, 10000.0, 1000.0
                )
            )
        )
        // when
        runBlocking {
            Mockito.`when`(api.getEventList()).thenReturn(response)

            val eventListData = service.getEventList()

            Mockito.verify(api).getEventList()
            // then
            assert(eventListData == response responseBy service.eventourMapper)
        }
    }

    @Test
    fun getEventDetail() {
        val response = Response.success(
            EventResponse(
                10L, "title", "description", 29292929292, "image",
                10000.0, 10000.0, 1000.0
            )
        )

        runBlocking {
            Mockito.`when`(api.getEventDetail(10L)).thenReturn(response)

            val eventListData = service.getEventDetail(10L)

            Mockito.verify(api).getEventDetail(10L)
            assert(eventListData == response responseBy service.eventourMapper)
        }
    }
}
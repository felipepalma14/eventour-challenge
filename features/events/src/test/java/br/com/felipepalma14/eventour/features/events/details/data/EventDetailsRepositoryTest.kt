package br.com.felipepalma14.eventour.features.events.details.data

import br.com.felipepalma14.eventour.features.events.home.data.EventListRepository
import br.com.felipepalma14.eventour.features.events.home.data.IEventListRepository
import br.com.felipepalma14.eventour.features.service.IEventourService
import br.com.felipepalma14.eventour.features.service.model.EventResponse
import br.com.felipepalma14.testingbase.TestCoroutineRule
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EventDetailsRepositoryTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    private lateinit var service: IEventourService

    private lateinit var repository: IEventDetailsRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = EventDetailsRepository(service)
    }

    @Test
    fun `should getEventList`() = testCoroutineRule.runBlockingTest {
        val id = 1L
        val response = mockk<EventResponse>()

        coEvery { service.getEventDetail(id) } returns response

        Truth.assertThat(repository.getEventDetails(id)).isEqualTo(response)
    }

}
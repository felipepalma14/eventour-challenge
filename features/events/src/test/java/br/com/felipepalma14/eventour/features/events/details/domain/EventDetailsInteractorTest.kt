package br.com.felipepalma14.eventour.features.events.details.domain

import br.com.felipepalma14.eventour.features.events.details.data.IEventDetailsRepository
import br.com.felipepalma14.eventour.features.events.details.domain.model.EventDataParams
import br.com.felipepalma14.eventour.features.events.domain.mapper.toEventData
import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.eventour.features.events.home.data.IEventListRepository
import br.com.felipepalma14.eventour.features.events.home.domain.EventListInteractor
import br.com.felipepalma14.eventour.features.events.home.domain.IEventListInteractor
import br.com.felipepalma14.eventour.features.service.model.EventResponse
import br.com.felipepalma14.testingbase.TestCoroutineRule
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EventDetailsInteractorTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    private lateinit var repository: IEventDetailsRepository

    private lateinit var interactor: IEventDetailsInteractor

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        mockkStatic("br.com.felipepalma14.eventour.features.events.domain.mapper.MapperKt")
        interactor = EventDetailsInteractor(repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `should getEventListData`() = testCoroutineRule.runBlockingTest {
        val params = EventDataParams(eventId = 1L)
        val itemData = mockk<EventData>()
        val itemResponse = mockk<EventResponse>()
        every { itemResponse.toEventData() } returns itemData
        coEvery { repository.getEventDetails(params.eventId) } returns itemResponse

        val result = interactor.getEventDetailsData(params)

        Truth.assertThat(result).isEqualTo(itemData)

    }
}
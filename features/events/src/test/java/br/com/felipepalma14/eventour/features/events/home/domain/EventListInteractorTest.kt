package br.com.felipepalma14.eventour.features.events.home.domain

import br.com.felipepalma14.eventour.features.events.domain.mapper.toEventData
import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.eventour.features.events.home.data.IEventListRepository
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
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EventListInteractorTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    private lateinit var repository: IEventListRepository

    private lateinit var interactor: IEventListInteractor

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        mockkStatic("br.com.felipepalma14.eventour.features.events.home.domain.EventListInteractorKt")
        interactor = EventListInteractor(repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `should getEventListData`() = testCoroutineRule.runBlockingTest {
        val itemData = mockk<EventData>()
        val itemResponse = mockk<EventResponse>()

        every { itemResponse.toEventData() } returns itemData

        coEvery { repository.getEventList() } returns listOf(itemResponse)

        val result = interactor.getEventListData()

        Truth.assertThat(result.isNotEmpty()).isTrue()
        Truth.assertThat(result.first()).isEqualTo(itemData)

    }
}
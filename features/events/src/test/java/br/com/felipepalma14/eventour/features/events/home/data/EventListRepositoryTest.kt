package br.com.felipepalma14.eventour.features.events.home.data

import br.com.felipepalma14.eventour.features.service.IEventourService
import br.com.felipepalma14.eventour.features.service.model.EventResponse
import br.com.felipepalma14.testingbase.TestCoroutineRule
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EventListRepositoryTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    private lateinit var service: IEventourService

    private lateinit var repository: IEventListRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = EventListRepository(service)
    }

    @Test
    fun `should getEventList`() = testCoroutineRule.runBlockingTest {
        val item = mockk<EventResponse>()
        val response = listOf(item)

        coEvery { service.getEventList() } returns response

        Truth.assertThat(repository.getEventList()).isEqualTo(response)
    }

}
package br.com.felipepalma14.eventour.features.events.details.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.felipepalma14.eventour.features.events.details.domain.IEventDetailsInteractor
import br.com.felipepalma14.eventour.features.events.details.domain.model.EventDataParams
import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.testingbase.TestCoroutineRule
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class EventDetailsViewModelTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var interactor: IEventDetailsInteractor

    @Mock
    private lateinit var state: Observer<EventDetailsViewModelState>

    @Mock
    private lateinit var action: Observer<EventDetailsAction>

    private lateinit var vm: EventDetailsViewModel

    private val params = EventDataParams(eventId = 1L)

    @Before
    fun setup() {
        vm = EventDetailsViewModel(
            interactor,
            params
        )

        vm.state.observeForever(state)
        vm.action.observeForever(action)
    }

    @Test
    fun `WHEN onCreate is called get event details`() {
        // given
        val data = mockk<EventData>()
        runBlocking {
            Mockito.`when`(interactor.getEventDetailsData(params)).thenReturn(data)
            vm.onCreate()

            Mockito.verify(state).onChanged(EventDetailsViewModelState.OnLoading)
            Mockito.verify(state).onChanged(EventDetailsViewModelState.OnGetEventDetails(data))
        }
    }

    @Test(expected = Throwable::class)
    fun `WHEN onCreate is called get error event list`() {
        // given
        runBlocking {
            Mockito.`when`(interactor.getEventDetailsData(params)).thenThrow(Throwable())
            vm.onCreate()

            Mockito.verify(state).onChanged(EventDetailsViewModelState.OnLoading)
            Mockito.verify(state).onChanged(EventDetailsViewModelState.OnError)
        }
    }

    @Test
    fun `WHEN user clicks event location SHOULD send OnEventLocationClick action`() {
        // given
        val data = mockk<EventData>()

        // when
        vm.onEventLocation()

        Mockito.verify(action).onChanged(EventDetailsAction.OnEventLocationClick(data))
    }
}
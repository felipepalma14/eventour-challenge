package br.com.felipepalma14.eventour.features.events.home.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.eventour.features.events.home.domain.IEventListInteractor
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
class EventListViewModelTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var interactor: IEventListInteractor

    @Mock
    private lateinit var state: Observer<EventListViewModelState>

    private lateinit var vm: EventListViewModel

    @Before
    fun setup() {
        vm = EventListViewModel(
            interactor
        )

        vm.state.observeForever(state)
    }

    @Test
    fun `WHEN onCreate is called get event list`() {
        // given
        val data = mockk<EventData>()
        runBlocking {
            Mockito.`when`(interactor.getEventListData()).thenReturn(listOf(data))
            vm.onCreate()

            Mockito.verify(state).onChanged(EventListViewModelState.OnLoading)
            Mockito.verify(state).onChanged(EventListViewModelState.OnGetEventList(listOf(data)))
        }
    }

    @Test
    fun `WHEN onCreate is called get empty event list`() {
        // given
        runBlocking {
            Mockito.`when`(interactor.getEventListData()).thenReturn(listOf())
            vm.onCreate()

            Mockito.verify(state).onChanged(EventListViewModelState.OnLoading)
            Mockito.verify(state).onChanged(EventListViewModelState.OnGetEventEmptyList)
        }
    }

    @Test(expected = Throwable::class)
    fun `WHEN onCreate is called get error event list`() {
        // given
        runBlocking {
            Mockito.`when`(interactor.getEventListData()).thenThrow(Throwable())
            vm.onCreate()

            Mockito.verify(state).onChanged(EventListViewModelState.OnLoading)
            Mockito.verify(state).onChanged(EventListViewModelState.OnError)
        }
    }
}
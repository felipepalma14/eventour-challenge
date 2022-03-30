package br.com.felipepalma14.eventour.features.events.home.presentation

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import br.com.felipepalma14.commons.base.BaseMvvmActivity
import br.com.felipepalma14.eventour.features.events.R
import br.com.felipepalma14.eventour.features.events.databinding.ActivityEventourHomeBinding
import br.com.felipepalma14.eventour.features.events.details.presentation.EventDetailsActivity
import br.com.felipepalma14.eventour.features.events.home.presentation.adapter.EventListAdapter

class EventourHomeActivity : BaseMvvmActivity() {

    private var vm by appViewModel<EventListViewModel>()
    private lateinit var binding: ActivityEventourHomeBinding
    private lateinit var adapter: EventListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_eventour_home)
        lifecycle.addObserver(vm)
        binding.lifecycleOwner = this

        setupListener()
        bindToolbarView()
        setSwipeRefresh()
        bindRecyclerView()
    }

    private fun bindToolbarView() {
        binding.toolbar.title = getString(R.string.home_toolbar_title)

    }

    private fun bindRecyclerView() {
        adapter = EventListAdapter { event ->
            vm.onEventClickItem(event.id)

        }
        binding.recyclerView.adapter = adapter

    }

    private fun setSwipeRefresh() {
        binding.swipe.setOnRefreshListener { vm.onCreate() }
    }

    private fun setupListener() {
        vm.state.observe(this) { state ->
            when (state) {
                is EventListViewModelState.OnGetEventList -> {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.listPlaceholder.visibility = View.GONE
                    binding.swipe.isRefreshing = false
                    adapter.submitList(state.vo)
                }
                is EventListViewModelState.OnLoading -> {
                    binding.recyclerView.visibility = View.GONE
                    binding.listPlaceholder.visibility = View.VISIBLE
                }
                is EventListViewModelState.OnGetEventEmptyList, EventListViewModelState.OnError -> {
                    binding.empty.visibility = View.VISIBLE
                }
            }
        }

        vm.action.observe(this) { action ->
            when (action) {
                is EventListAction.OnEventItemClick -> {
                    startActivity(EventDetailsActivity.newInstance(this, action.id))
                }
            }
        }
    }
}

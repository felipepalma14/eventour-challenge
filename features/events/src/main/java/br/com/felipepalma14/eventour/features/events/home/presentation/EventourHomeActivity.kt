package br.com.felipepalma14.eventour.features.events.home.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.felipepalma14.commons.base.BaseMvvmActivity
import br.com.felipepalma14.eventour.features.events.R
import br.com.felipepalma14.eventour.features.events.databinding.ActivityEventourHomeBinding
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
        bindRecyclerView()
    }

    private fun bindToolbarView() {
        binding.toolbar.title = "Eventos disponíveis"

    }

    private fun bindRecyclerView() {
        adapter = EventListAdapter {
            Toast.makeText(this, "${it.title}", Toast.LENGTH_LONG).show()
        }
        binding.recyclerView.adapter = adapter

    }

    private fun setupListener() {
        vm.state.observe(this) { state ->
            when (state) {
                is EventListViewModelState.OnGetEventList -> {
                    adapter.submitList(state.vo)
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.listPlaceholder.visibility = View.GONE
                }
                is EventListViewModelState.OnLoading -> {
                    binding.listPlaceholder.visibility = View.VISIBLE
                }
                is EventListViewModelState.OnGetEventEmptyList, EventListViewModelState.OnError -> {
                    binding.empty.visibility = View.VISIBLE
                }
            }
        }
    }
}

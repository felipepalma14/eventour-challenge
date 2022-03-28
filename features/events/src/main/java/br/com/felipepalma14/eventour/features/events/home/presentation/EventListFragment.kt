package br.com.felipepalma14.eventour.features.events.home.presentation

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils.loadLayoutAnimation
import android.view.animation.LayoutAnimationController
import androidx.core.content.ContextCompat.getColor
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import br.com.felipepalma14.commons.base.BaseFragment
import br.com.felipepalma14.eventour.features.events.R
import br.com.felipepalma14.eventour.features.events.databinding.FragmentEventListBinding
import br.com.felipepalma14.eventour.features.events.domain.model.EventData
import br.com.felipepalma14.eventour.features.events.home.presentation.adapter.EventListAdapter
import kotlinx.android.synthetic.main.fragment_event_list.*

class EventListFragment : BaseFragment<FragmentEventListBinding, EventListViewModel>(
    R.layout.fragment_event_list
) {


    private lateinit var adapter: EventListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        setSwipeRefresh()
        setObservers()

        adapter = EventListAdapter(EventListAdapter.OnClickListener {
            val bundle = bundleOf("event" to it)
            // view.findNavController().navigate(R.id.to_details, bundle)
        })
        viewBinding.recyclerView.adapter = adapter

        subscribeUi(viewBinding)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onInitDataBinding() {
        viewBinding.vm = viewModel
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, data: List<EventData>?) {
        val adapter = recyclerView.adapter as EventListAdapter
        adapter.submitList(data)
        adapter.notifyDataSetChanged()
        runAnimationAgain()
    }

    private fun setSwipeRefresh() {
        viewBinding.swipe.setColorSchemeColors(getColor(requireContext(), R.color.green))
        //viewBinding.swipe.setOnRefreshListener { viewModel.fetchFromRemote() }
    }

    private fun setObservers() {
//        viewModel.refreshing.observe(viewLifecycleOwner, Observer {
//            viewBinding.swipe.isRefreshing = it
//        })
//        viewModel.toast.observe(viewLifecycleOwner, Observer { msg ->
//            // showSnackBar(msg)
//        })

    }

    private fun subscribeUi(dateBinding: FragmentEventListBinding) {
//        viewModel.events.observe(viewLifecycleOwner, Observer { eventsList ->
//            viewBinding.progressBar.visibility = View.GONE
//            if (!eventsList.isNullOrEmpty()) {
//                //Timber.d(eventsList.toString())
//                setupRecyclerView(dateBinding.recyclerView,eventsList)
//            }
//        })
    }

    private fun runAnimationAgain() {
        val controller: LayoutAnimationController =
            loadLayoutAnimation(requireContext(), R.anim.layout_fall_down)
        recyclerView.layoutAnimation = controller
        adapter.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }
}
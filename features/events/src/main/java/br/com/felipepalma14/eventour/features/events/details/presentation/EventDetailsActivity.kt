package br.com.felipepalma14.eventour.features.events.details.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.felipepalma14.commons.base.BaseMvvmActivity
import br.com.felipepalma14.eventour.features.events.R
import br.com.felipepalma14.eventour.features.events.databinding.ActivityEventDetailsBinding
import br.com.felipepalma14.eventour.features.events.domain.model.EventData

class EventDetailsActivity : BaseMvvmActivity() {

    companion object {
        internal const val EVENT_ID = "eventId"
        fun newInstance(
            context: Context,
            id: Long
        ) = Intent(context, EventDetailsActivity::class.java)
            .putExtra(EVENT_ID, id)
    }


    private var vm by appViewModel<EventDetailsViewModel>()
    private lateinit var binding: ActivityEventDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_event_details)
        lifecycle.addObserver(vm)
        binding.lifecycleOwner = this

        binding.vm = vm

        bindToolbarView()
        setupListener()
    }

    private fun bindToolbarView() {
        binding.toolbar.title = getString(R.string.details_toolbar_title)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupListener() {
        binding.fabEventLocation.setOnClickListener {
            vm.onEventLocation()
        }

        vm.action.observe(this) { action ->
            when (action) {
                is EventDetailsAction.OnEventLocationClick -> {
                    toGoogleMaps(action.eventData)
                }
            }
        }
    }

    private fun toGoogleMaps(event: EventData) {
        val geo =
            "geo:${event.latitude},${event.longitude}?q=${event.latitude},${event.longitude}(Evento ${event.title})"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geo))
        startActivity(intent)
    }

}
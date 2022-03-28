package br.com.felipepalma14.eventour.features.events.home.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.felipepalma14.commons.base.BaseActivity
import br.com.felipepalma14.eventour.features.events.R
import br.com.felipepalma14.eventour.features.events.databinding.ActivityEventourHomeBinding

class EventourHomeActivity : BaseActivity<ActivityEventourHomeBinding, EventListViewModel>() {

    override fun getViewModelClass(): Class<EventListViewModel> =
        EventListViewModel::class.java

    override fun layoutId(): Int = R.layout.activity_eventour_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_eventour_home)
        binding.lifecycleOwner = this
    }
}

package br.com.felipepalma14.eventour.features.events.home.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.felipepalma14.eventour.features.events.R
import br.com.felipepalma14.eventour.features.events.databinding.ActivityEventourHomeBinding
import dagger.android.support.DaggerAppCompatActivity

class EventourHomeActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityEventourHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_eventour_home)
        binding.lifecycleOwner = this
    }
}
package br.com.felipepalma14.eventour

import android.content.Intent
import android.os.Bundle
import br.com.felipepalma14.eventour.features.events.home.presentation.EventourHomeActivity
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this,EventourHomeActivity::class.java))
        finish()
    }
}
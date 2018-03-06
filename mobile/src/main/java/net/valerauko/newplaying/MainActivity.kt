package net.valerauko.newplaying

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Switch
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val tag = "Main"
    private var settings: SharedPreferences? = null

    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        setContentView(R.layout.activity_main)
        Log.i(tag, "Started")
        Toast.makeText(this, "Starting up!", Toast.LENGTH_LONG).show()
        settings = getSharedPreferences("net.valerauko.newplaying.SETTINGS", Context.MODE_PRIVATE)
    }

    override fun onStart() {
        super.onStart()
        checkSwitches("mastodon", "twitter")
    }

    fun sendRequest(view: View) {
        if (CurrentTrack.track == "") {
            Toast.makeText(this, "No song playing!", Toast.LENGTH_LONG).show()
            return
        }
        val i = Intent("net.valerauko.newplaying.SEND_REQUESTED")
        sendBroadcast(i)
        Log.d(tag, "Sent post intent for ${CurrentTrack.track}")
    }

    private fun checkSwitches(vararg sendTo: String) {
        sendTo.forEach { platform ->
            val current = settings?.getBoolean(platform,true) ?: true
            val what = when(platform) { // i have no idea how to get id from string
                "mastodon" -> R.id.mastodon
                else -> R.id.twitter
            }
            val switch = findViewById(what) as Switch
            switch.isChecked = current
            switch.setOnCheckedChangeListener({ _, checked: Boolean ->
                val editor = settings?.edit()
                editor?.putBoolean(platform, checked)
                editor?.apply()
            })
        }
    }
}

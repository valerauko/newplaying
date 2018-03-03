package net.valerauko.newplaying

import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Dummy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPlayListener()
    }

    private fun addPlayListener() {
        val pFilter = IntentFilter()
        pFilter.addAction("com.jrtstudio.AnotherMusicPlayer.playstatechanged")
        pFilter.addAction("com.jrtstudio.AnotherMusicPlayer.metachanged")
        registerReceiver(PlayReceiver(), pFilter)
    }

}

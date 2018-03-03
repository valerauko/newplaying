package net.valerauko.newplaying

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.util.Log

class PlayListener : Service() {
    private var playReceiver = PlayReceiver()
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("PlayListener", "Started")
        addPlayListener()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun addPlayListener() {
        var pFilter = IntentFilter()
        pFilter.addAction("com.jrtstudio.AnotherMusicPlayer.playstatechanged")
        pFilter.addAction("com.jrtstudio.AnotherMusicPlayer.metachanged")
        registerReceiver(playReceiver, pFilter)
    }

//    private fun addWearListener() {
//        var wFilter = IntentFilter()
//        wFilter.addAction("com.google.android.gms.wearable.BIND_LISTENER")
//        registerReceiver(PostIt(playReceiver), wFilter)
//    }
}

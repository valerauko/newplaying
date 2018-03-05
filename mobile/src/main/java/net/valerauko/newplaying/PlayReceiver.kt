package net.valerauko.newplaying

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by valerauko on 18/03/03.
 */
class PlayReceiver : BroadcastReceiver() {
    private val tag = "PlayReceiver"

    override fun onReceive(context: Context?, intent: Intent?) {
        val message = "${intent?.getStringExtra("artist")} - " +
                "${intent?.getStringExtra("track")} " +
                "(${intent?.getStringExtra("album")})"
        CurrentTrack.track = message
        Log.i(tag, "CurrentTrack: ${CurrentTrack.track}")
    }
}
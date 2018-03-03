package net.valerauko.newplaying

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by valerauko on 18/03/03.
 */
public class PlayReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val message = "${intent?.getStringExtra("artist")} - " +
                "${intent?.getStringExtra("track")} " +
                "(${intent?.getStringExtra("album")})"
        Log.i("Play", "CurrentTrack: ${CurrentTrack.track}")
        Log.i("Play", "Setting to: $message")
        CurrentTrack.track = message
    }
}
package net.valerauko.newplaying

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by valerauko on 18/03/03.
 */
class PostIt: BroadcastReceiver() {
    private val tag = "PostIt"

    override fun onReceive(context: Context, intent: Intent?) {
        Log.i(tag, "Received post request.")
        val message = "#nowplaying ${CurrentTrack.track}"
        PostTwitter(context).execute(message)
        PostMastodon(context).execute(message)
    }
}
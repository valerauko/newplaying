package net.valerauko.newplaying

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.io.File

/**
 * Created by valerauko on 18/03/03.
 */
class PostIt: BroadcastReceiver() {
    private val tag = "PostIt"

    private var twitter = true
    private var mastodon = true

    override fun onReceive(context: Context, intent: Intent?) {
        Log.i(tag, "Received post request.")
        canPost(context)
        val message = "#nowplaying ${CurrentTrack.track}"
        if(twitter) PostTwitter(TwitterData()).execute(message)
        if(mastodon) PostMastodon(MastodonData()).execute(message)
    }

    // TODO: refactor to an abstract Poster class
    private fun canPost(ctx: Context) {
        val prefs = ctx.getSharedPreferences("net.valerauko.newplaying.SETTINGS", Context.MODE_PRIVATE)
        twitter = prefs.getBoolean("twitter",true)
        mastodon = prefs.getBoolean("mastodon", true)
    }
}
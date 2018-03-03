package net.valerauko.newplaying

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Created by valerauko on 18/03/03.
 */
class PostIt(received: PlayReceiver): BroadcastReceiver() {
    private var twitter = PostTwitter(received)
    private var mastodon = PostMastodon(received)

    override fun onReceive(context: Context?, intent: Intent?) {
        twitter.send()
        mastodon.send()
    }
}
package net.valerauko.newplaying

import android.content.Context
import android.util.Log
import twitter4j.TwitterException
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

/**
 * Created by valerauko on 18/03/03.
 */
class PostTwitter(ctx: Context): Poster(ctx, "twitter") {
    override val tag = "PostTwitter"

    override fun doInBackground(vararg msg: String): Boolean {
        if (!canPost) return true

        val config = ConfigurationBuilder()
        val data = TwitterData()
        val message = msg[0]
        config.setDebugEnabled(true)
                .setOAuthConsumerKey(data.key)
                .setOAuthConsumerSecret(data.nonce)
                .setOAuthAccessToken(data.token)
                .setOAuthAccessTokenSecret(data.secret)
        try {
            TwitterFactory(config.build()).instance.updateStatus(message)
            Log.i(tag, "Success")
        } catch (e: TwitterException) {
            Log.i(tag, "Failed")
            return false
        }
        return true
    }
}
package net.valerauko.newplaying

import android.os.AsyncTask
import android.util.Log
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

/**
 * Created by valerauko on 18/03/03.
 */
class PostTwitter(val data: TwitterData): AsyncTask<String, Void, String>() {
    private val tag = "PostTwitter"

    override fun doInBackground(vararg msg: String): String {
        val config = ConfigurationBuilder()
        val message = msg[0]
        config.setDebugEnabled(true)
            .setOAuthConsumerKey(data.key)
            .setOAuthConsumerSecret(data.nonce)
            .setOAuthAccessToken(data.token)
            .setOAuthAccessTokenSecret(data.secret)
        val result = TwitterFactory(config.build()).instance.updateStatus(message)
        Log.i(tag, result.toString())
        return message
    }
}
package net.valerauko.newplaying

import android.content.Context
import android.util.Log
import java.io.OutputStreamWriter
import java.net.HttpURLConnection

/**
 * Created by valerauko on 18/03/03.
 */
class PostMastodon(ctx: Context): Poster(ctx, "mastodon") {
    override val tag = "PostMastodon"

    override fun doInBackground(vararg msg: String): Boolean {
        if (!canPost) return true
        val data = MastodonData()
        with(data.url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Authorization", "Bearer ${data.user}")
            doOutput = true

            val message = msg[0]

            val writer = OutputStreamWriter(outputStream)
            writer.write("client_id=${data.token}&client_secret=${data.secret}&" +
                    "visibility=public&sensitive=false&status=$message")
            writer.flush()
            writer.close()
            Log.i(tag, responseMessage)
            disconnect()

            return responseMessage == "OK"
        }
    }
}
package net.valerauko.newplaying

import android.os.AsyncTask
import android.util.Log
import java.io.OutputStreamWriter
import java.net.HttpURLConnection

/**
 * Created by valerauko on 18/03/03.
 */
class PostMastodon(val data: MastodonData): AsyncTask<String, Void, String>() {
    private val tag = "PostMastodon"

    override fun doInBackground(vararg msg: String): String {
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

            return message
        }
    }
}
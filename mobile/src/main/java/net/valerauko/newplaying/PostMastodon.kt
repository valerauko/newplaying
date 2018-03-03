package net.valerauko.newplaying

import android.util.Log
import java.io.File
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by valerauko on 18/03/03.
 */
class PostMastodon(received: PlayReceiver) {
    private var url: URL
    private var token: String? = ""
    private var secret: String? = ""
    private var user: String? = ""
    private val message: String = ""

    init {
        // file's lines have to be: token/secret/user secret/instance url
        val lines = File("mastodon.secret").readLines()
        token = lines[0]
        secret = lines[1]
        user = lines[2]
        url = URL(lines[3])
    }

    fun send() {
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Authorization", "Bearer $user")
            doOutput = true

            val writer = OutputStreamWriter(outputStream)
            writer.write("client_id=$token&client_secret=$secret&" +
                    "visibility=public&sensitive=false&status=$message")
            writer.flush()
            writer.close()
            Log.i("Mastodon", responseMessage)
            disconnect()
        }
    }
}
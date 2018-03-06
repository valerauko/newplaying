package net.valerauko.newplaying
import android.content.Context
import android.os.AsyncTask
import android.widget.Toast

/**
 * Created by valerauko on 18/03/06.
 */
abstract class Poster(ctx: Context, private val service: String): AsyncTask<String, Void, Boolean>() {
    protected abstract val tag: String

    // it doesn't leak because it's applicationContext
    private val context = ctx.applicationContext
    private val prefs = context.getSharedPreferences("net.valerauko.newplaying.SETTINGS", Context.MODE_PRIVATE)
    protected val canPost = prefs.getBoolean(service,true)

    override fun onPostExecute(result: Boolean) {
        if (!canPost) return
        val message = if (result) "Posted to $service!" else "Failed to post to $service!"
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
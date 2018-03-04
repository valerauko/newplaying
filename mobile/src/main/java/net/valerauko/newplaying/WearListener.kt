package net.valerauko.newplaying

import android.util.Log
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.WearableListenerService
import android.content.Intent

/**
 * Created by valerauko on 18/03/03.
 */
class WearListener: WearableListenerService() {
    private val tag: String = "WearListener"

    override fun onCreate() {
        Log.d(tag, "Created")
        super.onCreate()
    }

    override fun onMessageReceived(event: MessageEvent?) {
        if(CurrentTrack.track == "") {
            Log.i(tag, "No track playing.")
            return
        }
        val i = Intent("net.valerauko.newplaying.SEND_REQUESTED")
        sendBroadcast(i)
        Log.d(tag, "Sent post intent for ${CurrentTrack.track}")
    }
}
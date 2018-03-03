package net.valerauko.newplaying

import android.util.Log
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.WearableListenerService
import android.content.Intent



/**
 * Created by valerauko on 18/03/03.
 */
class WearListener: WearableListenerService() {
    override fun onCreate() {
        Log.d("WearListener", "Created")
        super.onCreate()
    }

    override fun onMessageReceived(event: MessageEvent?) {
        val i = Intent("net.valerauko.newplaying.RANDOM")
        sendBroadcast(i)
        Log.d("WearListener", "Posting ${CurrentTrack.track}")
    }
}
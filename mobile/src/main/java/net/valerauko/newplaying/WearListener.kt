package net.valerauko.newplaying

import android.util.Log
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.WearableListenerService

/**
 * Created by valerauko on 18/03/03.
 */
class WearListener: WearableListenerService() {
    override fun onCreate() {
        Log.d("WearListener", "Created")
        super.onCreate()
    }

    override fun onMessageReceived(p0: MessageEvent?) {
        Log.d("WearListener", "Posting ${CurrentTrack.track}")
    }
}
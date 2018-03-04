package net.valerauko.newplaying

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import android.view.View
import com.google.android.gms.wearable.Wearable
import java.time.LocalDateTime

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendPost(v: View) {
        Log.i("Watch", "Called!")

        val client = Wearable.getMessageClient(this)
        Wearable.getNodeClient(this).connectedNodes.addOnSuccessListener { result ->
            val phone = result[0]
            client.sendMessage(phone.id, "/nowplaying",
                LocalDateTime.now().toString().toByteArray())
            Log.i("Watch", "Sent to ${phone.displayName}!")
        }
    }
}

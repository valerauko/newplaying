package net.valerauko.newplaying

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class Dummy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Main", "Started")
        Toast.makeText(this, "Starting up!", Toast.LENGTH_LONG).show()
        finish()
    }
}

package com.example.kotlinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import network.ConnectsApi
import okhttp3.Dispatcher
import repositories.ConnectsRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val rep = ConnectsRepository(ConnectsApi())
//
//        GlobalScope.launch(Dispatchers.Main) {
//            val connects = rep.getConnects()
//
//            Toast.makeText(this@MainActivity,connects.toString(),Toast.LENGTH_LONG).show()
//        }
    }
}

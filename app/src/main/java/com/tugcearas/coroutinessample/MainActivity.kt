package com.tugcearas.coroutinessample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ----- Run Blocking -----
//        println("run blocking start")
//        runBlocking {
//            launch {
//                delay(2000)
//                println("run blocking")
//            }
//        }
//        println("run blocking end")

        // ----- Global Scope -----
//        println("global scope start")
//        GlobalScope.launch {
//            delay(2000)
//            println("global scope")
//        }
//        println("global scope end")

        // ----- Coroutine Scope -----
//        println("coroutine scope start")
//        CoroutineScope(Dispatchers.Default).launch {
//            delay(2000)
//            println("coroutine scope")
//        }
//        println("coroutine scope end")
    }
}

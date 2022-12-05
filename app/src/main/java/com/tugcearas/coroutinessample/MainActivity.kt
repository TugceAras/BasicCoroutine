package com.tugcearas.coroutinessample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Coroutine Exception Handling
        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception : ${throwable.localizedMessage}")
        }

        lifecycleScope.launch(handler) {
            throw Exception("Error!")
        }

        lifecycleScope.launch(handler) {
            launch {
                throw Exception("Error!")
            }
            launch {
                delay(1000)
                println("This is executed")
            }
        }

        // supervisoScope
        lifecycleScope.launch(handler) {
           supervisorScope {
               launch {
                   throw Exception("Error!")
               }
               launch {
                   delay(1000)
                   println("This is executed")
               }
           }
        }

        // error handling can also be used as:
        CoroutineScope(Dispatchers.Main + handler).launch {
            //...
        }

       // ----- Run Blocking -----
        println("run blocking start")
        runBlocking {
            launch {
                delay(2000)
                println("run blocking")
            }
        }
        println("run blocking end")

         //----- Global Scope -----
        println("global scope start")
        GlobalScope.launch {
            delay(2000)
            println("global scope")
        }
        println("global scope end")

        // ----- Coroutine Scope -----
        println("coroutine scope start")
        CoroutineScope(Dispatchers.Default).launch {
            delay(2000)
            println("coroutine scope")
        }
        println("coroutine scope end")

    }
}


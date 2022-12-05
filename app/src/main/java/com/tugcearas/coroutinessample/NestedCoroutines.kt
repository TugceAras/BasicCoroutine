package com.tugcearas.coroutinessample

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    runBlocking {
        launch {
            delay(4000)
            println("run blocking")
        }
        coroutineScope {
            launch {
                delay(2000)
                println("coroutine scope")
            }
        }
    }
}



package com.tugcearas.coroutinessample

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val myJob = launch {
            delay(2000)
            println("job 1")
        }

        myJob.invokeOnCompletion {
            println("job ended")
        }

        myJob.cancel()
    }
}

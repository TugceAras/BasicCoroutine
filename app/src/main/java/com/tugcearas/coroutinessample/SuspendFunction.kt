package com.tugcearas.coroutinessample

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        delay(2000)
        println("run blocking")
        testCoroutine()
    }
}

suspend fun testCoroutine() {
    coroutineScope {
        delay(4000)
        println("suspend function")
    }
}


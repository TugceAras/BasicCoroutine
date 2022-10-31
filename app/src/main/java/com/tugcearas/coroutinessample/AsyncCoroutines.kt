package com.tugcearas.coroutinessample

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    var userName = ""
    var userAge = 0

//    runBlocking {
//        launch {
//            val name =  downloadName()
//            val age = downloadAge()
//            println("$name $age")
//        }
//    }

//    runBlocking {
//        launch {
//            val name = downloadName()
//            userName = name
//        }
//
//        launch {
//            val age = downloadAge()
//            userAge = age
//        }
//
//        println("$userName $userAge")
//    }

    runBlocking {
        val downloadedName = async {
            downloadName()
        }

        val downloadedAge = async {
            downloadAge()
        }

        userName = downloadedName.await()
        userAge = downloadedAge.await()
        println("$userName $userAge")
    }
}

suspend fun downloadName(): String {
    delay(2000)
    val userName = "Tom"
    println("username download")
    return userName
}

suspend fun downloadAge(): Int {
    delay(4000)
    val age = 23
    println("age download")
    return age
}

package com.example.toystore.repository

object IndexSingleton {

    var index : Int = 0

    fun incrementIndex(){
        index++
    }

    fun resetIndex(){
        index = 0
    }
}
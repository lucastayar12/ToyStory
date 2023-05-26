package com.example.toystore.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Brinquedo(var codigo : Int, var modelo : String, var idade : Int, var peso : Float, var volume : Float, var custo : Float) : Parcelable{
}
package com.aula.geral

import kotlin.random.Random

data class Login (
    var codlogin: Int = getID(),
    var username : String = "",
    var password : String = ""
)
{
    companion object {
        fun getID(): Int {
            //val random = Random().nextInt(100)
            return Random.nextInt(100)
        }
    }
}
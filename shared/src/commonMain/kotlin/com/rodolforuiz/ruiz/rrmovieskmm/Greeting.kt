package com.rodolforuiz.ruiz.rrmovieskmm

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
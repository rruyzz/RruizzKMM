package com.rodolforuiz.ruiz.rrmovieskmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
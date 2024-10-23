package com.rodolforuiz.ruiz.rrmovieskmm

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {

    val scope: CoroutineScope
}
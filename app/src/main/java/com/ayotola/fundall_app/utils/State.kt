package com.ayotola.fundall_app.utils

data class State <T> (
    val loading: Boolean = false,
    val error: Event<String>? = null,
    val navigate: Event<Boolean>? = null,
    val data: T? = null
)
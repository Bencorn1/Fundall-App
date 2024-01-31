package com.ayotola.fundall_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

abstract class BaseVM<T> : ViewModel() {
    val _state = MediatorLiveData<State<T>>()
    val state: LiveData<State<T>> = _state

    protected fun loadData(block: suspend () -> T) {
        viewModelScope.launch {
            try {
                _state.value = State(true)

                updateState { it.copy(data = block(), navigate = Event(true)) }
            } catch (ex: Throwable) {
                ex.printStackTrace()

               updateState { it.copy(error = Event(resolveErrorMessage(ex))) }
            } finally {
                updateState { it.copy(loading = false) }
            }
        }
    }

    protected fun load(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                _state.value = State(true)

                block()
            } catch (ex: Throwable) {
                ex.printStackTrace()

               updateState { it.copy(error = Event(resolveErrorMessage(ex))) }
            } finally {
                updateState { it.copy(loading = false) }
            }
        }
    }

    private suspend fun updateState(update: suspend (state: State<T>) -> State<T>) {
        val currentState = _state.value ?: State()
        _state.value = update(currentState)
    }

    private fun resolveErrorMessage(throwable: Throwable): String {
        return when (throwable) {
            is HttpException -> {
                val errorResponse = throwable.response()?.errorBody()?.string()?.parseError()
                errorResponse?.detail ?: "HTTP Error: ${throwable.code()}"
            }
            is IOException -> {
                "Network Error: ${throwable.localizedMessage}"
            }
            else -> {
                "Error: ${throwable.localizedMessage}"
            }
        }
    }
}
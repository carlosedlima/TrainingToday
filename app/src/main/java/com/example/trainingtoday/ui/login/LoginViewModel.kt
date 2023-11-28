package com.example.trainingtoday.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trainingtoday.R

class LoginViewModel: ViewModel() {
    private val _emailFieldErrorResId = MutableLiveData<Int>()
    val emailFieldErrorResId: LiveData<Int?> = _emailFieldErrorResId

    private val _passFieldErrorResId = MutableLiveData<Int>()
    val passFieldErrorResId: LiveData<Int?> = _passFieldErrorResId

    private var isFormValid = false

    private fun getErrorStringResIdIfEmpty(value: String): Int? {
        return if (value.isEmpty()) {
            isFormValid = false
            R.string.field_error
        } else null
    }
}
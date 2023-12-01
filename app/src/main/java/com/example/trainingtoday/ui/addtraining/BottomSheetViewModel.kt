package com.example.trainingtoday.ui.addtraining

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trainingtoday.R
import com.example.trainingtoday.domain.repository.TrainingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class BottomSheetViewModel @Inject constructor(
    repository: TrainingRepository
) : ViewModel() {
    private val _nameFieldErrorResId = MutableLiveData<Int>()
    val nameFieldErrorResId: LiveData<Int?> = _nameFieldErrorResId

    private val _observacoesFieldErrorResId = MutableLiveData<Int>()
    val observacoesFieldErrorResId: LiveData<Int?> = _observacoesFieldErrorResId

    private val _dataFieldErrorResId = MutableLiveData<Int>()
    val dataFieldErrorResId: LiveData<Int?> = _dataFieldErrorResId

    private var isFormValid = false

    private fun getErrorStringResIdIfEmpty(value: String): Int? {
        return if (value.isEmpty()) {
            isFormValid = false
            R.string.field_error
        } else null
    }
    private fun getErrorDateResIdIfEmpty(value: Date): Int? {
        return if (value.equals("")) {
            isFormValid = false
            R.string.field_error
        } else null
    }
}
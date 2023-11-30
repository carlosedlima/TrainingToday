package com.example.trainingtoday.ui.training

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingtoday.domain.repository.TrainingRepository
import com.example.trainingtoday.domain.Training
import com.example.trainingtoday.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListTrainingViewModel @Inject constructor(
    private val dataSource: TrainingRepository
) : ViewModel() {
    private val _trainingList = MutableLiveData<Resource<List<Training>>>()
    val trainingList: LiveData<Resource<List<Training>>> get() = _trainingList

    fun loadTraining() {
        viewModelScope.launch {
            _trainingList.value = dataSource.getTraining()
        }
    }

    fun addTraining(training: Training) {
        viewModelScope.launch {
            dataSource.createTraining(training)
            loadTraining()
        }
    }

    fun deleteTrainingById(id: String) {
        viewModelScope.launch {
            dataSource.deleteTrainingById(id)
            loadTraining()
        }
    }
}
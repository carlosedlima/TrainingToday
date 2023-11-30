package com.example.trainingtoday.domain.repository

import com.example.trainingtoday.domain.Training
import com.example.trainingtoday.utils.Resource


interface TrainingRepository {

    suspend fun getTraining():Resource<List<Training>>

    suspend fun getTrainingById(id: String): Training?

    suspend fun createTraining(training: Training)

    suspend fun deleteTrainingById(id: String)

//    suspend fun getNotes(user: User?, result: (Resource<List<Training>>) -> Unit)
//
//    suspend fun updateNote(note: Note, result: (Resource<String>) -> Unit)
//    suspend fun deleteNote(note: Note, result: (Resource<String>) -> Unit)

}
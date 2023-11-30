package com.example.trainingtoday.data.remote

import android.util.Log
import com.example.trainingtoday.domain.repository.TrainingRepository
import com.example.trainingtoday.domain.Training
import com.example.trainingtoday.utils.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class TrainingRepositoryImpl @Inject constructor(
    fireStore: FirebaseFirestore
) : TrainingRepository {

    private val trainingCollection = fireStore.collection("treino")

    override suspend fun getTraining(): Resource<List<Training>> {
        return try {
            val querySnapshot = trainingCollection.get().await()
            Log.d("GET_TRAINING", "Number of documents: ${querySnapshot.size()}")

            val trainings = querySnapshot.documents.mapNotNull { document ->
                try {
                    document.toObject(Training::class.java)
                } catch (e: Exception) {
                    Log.e("GET_TRAINING", "Erro ao converter documento para Training: ${e.message}")
                    null
                }
            }

            Resource.Success(trainings)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("GET_TRAINING", "Erro ao obter treinamentos: ${e.message}")
            Resource.Success(emptyList())
        }
    }
    override suspend fun getTrainingById(id: String): Training? {
        return try {
            val documentSnapshot = trainingCollection.document(id).get().await()
            documentSnapshot.toObject(Training::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun createTraining(training: Training) {
        try {
            trainingCollection.add(training).await()
        } catch (e: Exception) {
            // Handle the exception
        }
    }

    override suspend fun deleteTrainingById(id: String) {
        try {
            trainingCollection.document(id).delete().await()
        } catch (e: Exception) {
            // Handle the exception
        }
    }
}
package com.example.trainingtoday.ui.exercises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trainingtoday.databinding.ActivityListExerciseBinding

class ListExerciseActivity : AppCompatActivity() {

    private var _binding: ActivityListExerciseBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
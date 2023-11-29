package com.example.trainingtoday.ui.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.trainingtoday.databinding.ActivityListTrainingBinding

class ListTrainingActivity : AppCompatActivity() {

    private var _binding: ActivityListTrainingBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityListTrainingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
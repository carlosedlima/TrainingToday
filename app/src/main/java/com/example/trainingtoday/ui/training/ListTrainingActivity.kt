package com.example.trainingtoday.ui.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trainingtoday.databinding.ActivityListBinding

class ListTrainingActivity : AppCompatActivity() {

    private var _binding: ActivityListBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
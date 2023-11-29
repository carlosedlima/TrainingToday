package com.example.trainingtoday.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.trainingtoday.R
import com.example.trainingtoday.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observerVM()
    }

    private fun observerVM(){
        viewModel.emailFieldErrorResId.observe(this) { stringResId ->
            binding.tlEmail.setError(stringResId)
        }
        viewModel.passFieldErrorResId.observe(this) { stringResId ->
            binding.tlSenha.setError(stringResId)
        }
    }


    private fun TextInputLayout.setError(stringResId: Int?) {
        error = if (stringResId != null) {
            getString(stringResId)
        } else null
    }
}
package com.example.trainingtoday.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.trainingtoday.R
import com.example.trainingtoday.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerVM()

    }
    private fun observerVM(){
        viewModel.emailFieldErrorResId.observe(viewLifecycleOwner) { stringResId ->
            binding.tlEmail.setError(stringResId)
        }
        viewModel.passFieldErrorResId.observe(viewLifecycleOwner) { stringResId ->
            binding.tlSenha.setError(stringResId)
        }
    }


    private fun TextInputLayout.setError(stringResId: Int?) {
        error = if (stringResId != null) {
            getString(stringResId)
        } else null
    }
}
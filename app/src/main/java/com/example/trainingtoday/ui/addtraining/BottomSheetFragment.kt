package com.example.trainingtoday.ui.addtraining

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.trainingtoday.R
import com.example.trainingtoday.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

@AndroidEntryPoint
class BottomSheetFragment : BottomSheetDialogFragment(){

    private val tag:String = "GET_BOTTOM_SHEET"

    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!
    private val viewModel:BottomSheetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.DataButton.setOnClickListener {
            Log.d(tag,"botão data clickado")
            datePickerCall()
        }

        binding.BotaoRegistrar.setOnClickListener {
            val nome = binding.etNome.text.toString()
            val observacoes = binding.etObservacoes.text.toString()
            val dateString = binding.DataButton.text.toString()
            val date = stringToDate(dateString)
            Log.d(tag,"$nome$observacoes$dateString$date}")
        }

        vmEvents()
        todayDate()
    }

    private fun datePickerCall() {
        val datePicker = DatePickerDialog(requireContext())

        datePicker.setOnDateSetListener { _, ano, mes, dia ->
            run {
                val mes = mes + 1
                val date: String = makeDateString(dia, mes, ano)
                binding.DataButton.text = date
            }
        }

        datePicker.show()
    }

    private fun todayDate(){
        val cal: Calendar = Calendar.getInstance()
        val dia:Int = cal.get(Calendar.DAY_OF_MONTH)
        val mes:Int = cal.get(Calendar.MONTH)
        val ano:Int = cal.get(Calendar.YEAR)
        binding.DataButton.text = makeDateString(dia,mes,ano)
    }
    private fun stringToDate(dateString: String): Date? {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.parse(dateString)
    }

    private fun vmEvents(){
        viewModel.nameFieldErrorResId.observe(this) { stringResId ->
            binding.tlNome.setError(stringResId)
        }

        viewModel.observacoesFieldErrorResId.observe(this) { stringResId ->
            binding.tlObservacoes.setError(stringResId)
        }
    }

    private fun TextInputLayout.setError(stringResId: Int?) {
        error = if (stringResId != null) {
            getString(stringResId)
        } else null
    }

    private fun makeDateString(dia:Int,mes:Int,ano:Int): String{
        return "${dia}/${mes}/${ano}"
    }

}
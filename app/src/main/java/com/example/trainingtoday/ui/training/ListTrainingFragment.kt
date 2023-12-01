package com.example.trainingtoday.ui.training

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingtoday.databinding.FragmentListTrainingBinding
import com.example.trainingtoday.ui.addtraining.BottomSheetFragment
import com.example.trainingtoday.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListTrainingFragment : Fragment() {

    companion object {
        fun newInstance() = ListTrainingFragment()
    }

    private val TAG :String = "GET_TRAINING_ACTIVITY"

    private var _binding: FragmentListTrainingBinding? = null
    private val binding get() = _binding!!

    private val viewModel:  ListTrainingViewModel by viewModels()

    private val adapter = ListTrainingAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListTrainingBinding.inflate(layoutInflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTraining.adapter = adapter
        binding.rvTraining.layoutManager = LinearLayoutManager(context)

        binding.rvTraining.setOnClickListener {

        }

        binding.fabAdicionar.setOnClickListener {
            val bottomSheet = BottomSheetFragment()
            bottomSheet.show(parentFragmentManager,"BottomSheetDialog")
        }

        viewModel.loadTraining()
        viewModel.trainingList.observe(viewLifecycleOwner){ resourse ->
            when(resourse){
                is Resource.Loading ->{
                    Log.d(TAG,"Loading")
                }
                is Resource.Success ->{
                    adapter.set(resourse.data)
                }
                is Resource.Failure ->{
                    Log.d(TAG,"Deu ruim")
                }
            }
        }

    }

}
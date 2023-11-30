package com.example.trainingtoday.ui.trainingdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trainingtoday.R

class ListTrainingDetails : Fragment() {

    companion object {
        fun newInstance() = ListTrainingDetails()
    }

    private lateinit var viewModel: ListTrainingDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_training_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListTrainingDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
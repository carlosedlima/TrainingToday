package com.example.trainingtoday.ui.training


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingtoday.databinding.CardTrainingBinding
import com.example.trainingtoday.domain.Training
import com.example.trainingtoday.utils.BaseAdapter

class ListTrainingAdapter : BaseAdapter<ListTrainingAdapter.TrainingViewHolder, Training>() {
    inner class TrainingViewHolder(val binding: CardTrainingBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val binding = CardTrainingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TrainingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.binding.tvNome.text = items[position].nome.toString()
        holder.binding.tvData.text = items[position].data.toString()
    }
}
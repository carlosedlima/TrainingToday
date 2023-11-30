package com.example.trainingtoday.ui.trainingdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trainingtoday.databinding.CardExerciseBinding
import com.example.trainingtoday.domain.Exercise
import com.example.trainingtoday.utils.BaseAdapter


class ListExerciseAdapter : BaseAdapter<ListExerciseAdapter.ExerciseViewHolder, Exercise>() {

    inner class ExerciseViewHolder(val binding: CardExerciseBinding ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val binding = CardExerciseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ExerciseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.binding.txtNome.text = items[position].nome.toString()
        holder.binding.txtObservacoes.text = items[position].observacoes
        Glide.with(holder.itemView.context)
            .load(items[position].imagem)
            .into(holder.binding.imgExercicio)
    }

}
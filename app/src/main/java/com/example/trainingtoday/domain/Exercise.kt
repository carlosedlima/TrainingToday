package com.example.trainingtoday.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Exercise (
    val nome:Int,
    val imagem: String?,
    val observacoes:String,
):Parcelable{
    constructor() : this(0, "", "")
}
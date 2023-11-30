package com.example.trainingtoday.domain

import android.os.Parcelable
import com.google.firebase.firestore.ServerTimestamp
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Training(
    @ServerTimestamp
    val data: Date,
    val descricao:String,
    val nome:Int
): Parcelable{
    constructor() : this(Date(), "", 0)
}

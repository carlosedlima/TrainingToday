package com.example.trainingtoday.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

val ViewGroup.inflater: LayoutInflater
    get() = LayoutInflater.from(this.context)

fun ViewGroup.inflate(@LayoutRes layout: Int): View = inflater.inflate(layout, this, false)


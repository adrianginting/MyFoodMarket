package com.adrianterastaginting.myfoodmarket.model.dummy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeModel(
    var title: String,
    var src: String,
    var rating: Float
) : Parcelable
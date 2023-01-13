package com.adrianterastaginting.myfoodmarket.model.dummy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeVerticalModel(
    var title: String,
    var price: String,
    var src: String,
    var rating: Float
) : Parcelable
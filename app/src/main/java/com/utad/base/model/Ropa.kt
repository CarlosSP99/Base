package com.utad.base.model

import com.google.gson.annotations.SerializedName

data class Ropa(
    @SerializedName("id") val id: Int=0,
    @SerializedName("title") val title: String="",
    @SerializedName("description") val description: String="",
    @SerializedName("image") val image: String="",
    @SerializedName("price") val price: Double=0.0,


    )


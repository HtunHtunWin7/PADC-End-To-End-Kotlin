package com.greenovator.padc_end_to_end_kotlin.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class Tips(
    @ColumnInfo(name = "temperature")
    @SerializedName("temperature")
    val temperature: String,
    @ColumnInfo(name = "light")
    @SerializedName("light")
    val light :String,
    @ColumnInfo(name = "placement")
    @SerializedName("placement")
    val placement: String

)

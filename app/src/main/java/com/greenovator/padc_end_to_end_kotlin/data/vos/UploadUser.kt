package com.greenovator.padc_end_to_end_kotlin.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class UploadUser(
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "user_photo")
    @SerializedName("user_photo")
    val userPhoto: String,
    @ColumnInfo(name = "uploaded_time")
    @SerializedName("uploaded_time")
    val uploadedTime: String,
    @ColumnInfo(name = "user_rank")
    @SerializedName("user_rank")
    val userRank: String

)

package com.greenovator.padc_end_to_end_kotlin.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "plants")
data class PlantVO (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "plant_id")
    @SerializedName("plant_id")
    val plantId: String,

    @ColumnInfo(name = "plant_name")
    @SerializedName("plant_name")
    val plantName: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,

    @SerializedName("uploaded_user")
    @Embedded(prefix = "uploaded_user")
    val uploadUser: UploadUser,

    @ColumnInfo(name = "plant_photo")
    @SerializedName("plant_photo")
    val plantPhoto: String

   /* @SerializedName("plant_type")
    @Ignore
    val plantType: List<String>,



    @ColumnInfo(name = "top_tip")
    @SerializedName("top_tip")
    val topTip: String,

    @SerializedName("tips")
    @Ignore
    val tips: Tips,

    @Ignore

    */

)

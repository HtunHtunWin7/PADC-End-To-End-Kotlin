package com.greenovator.padc_end_to_end_kotlin.networks.response

import com.google.gson.annotations.SerializedName
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO
import com.greenovator.padc_end_to_end_kotlin.utils.CODE_RESPONSE_OK

data class PlantResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: List<PlantVO>
){
    fun isResponseOK():Boolean{
        return code == CODE_RESPONSE_OK && data != null
    }
}

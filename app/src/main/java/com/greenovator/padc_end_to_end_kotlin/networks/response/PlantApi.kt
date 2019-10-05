package com.greenovator.padc_end_to_end_kotlin.networks.response

import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO
import com.greenovator.padc_end_to_end_kotlin.utils.GET_PLANTS
import com.greenovator.padc_end_to_end_kotlin.utils.LOGIN
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PlantApi {

    @POST(GET_PLANTS)
    fun getAllPlants():retrofit2.Call<PlantResponse>

    @POST(LOGIN)
    @FormUrlEncoded
    fun setUserLogin(@Field("email") email:String,@Field("password")password:String):Call<UserLoginResponse>
}
package com.greenovator.padc_end_to_end_kotlin.data.models

import androidx.lifecycle.LiveData
import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO

interface PlantModel {
    fun getPlants(
        onFailure: (String)-> Unit
    ):LiveData<List<PlantVO>>
    fun loginUser(
        onSuccess: (List<LoginVO>)-> Unit,
        onFailure: (String) -> Unit
    )
    fun getFindById(id: Int) :LiveData<PlantVO>
}
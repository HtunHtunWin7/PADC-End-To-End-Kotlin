package com.greenovator.padc_end_to_end_kotlin.data.models

import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO

interface PlantModel {
    fun getPlants(
        onSuccess: (List<PlantVO>) ->Unit,
        onFailure: (String)-> Unit
    )
    fun loginUser(
        onSuccess: (List<LoginVO>)-> Unit,
        onFailure: (String) -> Unit
    )
    fun getFindById(id: Int) :PlantVO
}
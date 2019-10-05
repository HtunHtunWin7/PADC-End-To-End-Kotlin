package com.greenovator.padc_end_to_end_kotlin.networks.dataagents

import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO

interface PlantDataAgent {
    fun getPlants(
        onSuccess: (List<PlantVO> )-> Unit,
        onFailure:(String)-> Unit
    )
    fun setLogin(
        onSuccess: (List<LoginVO>) -> Unit,
        onFailure: (String) -> Unit
    )
}
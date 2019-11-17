package com.greenovator.padc_end_to_end_kotlin.delegate

interface PlantDelegate {
    fun onTapPlantItem(id:Int)

    fun onClickLogin(email: String, password: String)
}
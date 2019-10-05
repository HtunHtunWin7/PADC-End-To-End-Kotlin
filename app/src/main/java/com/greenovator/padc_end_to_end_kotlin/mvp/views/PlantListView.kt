package com.greenovator.padc_end_to_end_kotlin.mvp.views

import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO

interface PlantListView: BaseView {
    fun displayPlantList(plantList: List<PlantVO>)
    fun displayError(errorMessage: String)
    fun navigateToNavigate(plantId: Int)
}
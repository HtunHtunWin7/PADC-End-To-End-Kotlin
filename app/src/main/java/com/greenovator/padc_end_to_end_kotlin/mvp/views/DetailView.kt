package com.greenovator.padc_end_to_end_kotlin.mvp.views

import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO

interface DetailView:BaseView {
    fun displayPlantDetail(plantVO: PlantVO)
}
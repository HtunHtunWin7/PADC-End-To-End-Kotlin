package com.greenovator.padc_end_to_end_kotlin.mvp.presenters

import com.greenovator.padc_end_to_end_kotlin.data.models.PlantModelImp
import com.greenovator.padc_end_to_end_kotlin.mvp.views.DetailView

class DetailPresenter:BasePresenter<DetailView>() {

    fun onUIReady(plantId: Int){
        if(plantId !=0){
            val model =PlantModelImp
            val plantModel =model.getFindById(plantId)
            mView.displayPlantDetail(plantModel)
        }
    }
}
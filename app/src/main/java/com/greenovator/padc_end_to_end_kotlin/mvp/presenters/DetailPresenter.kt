package com.greenovator.padc_end_to_end_kotlin.mvp.presenters

import androidx.lifecycle.Observer
import com.greenovator.padc_end_to_end_kotlin.activities.DetailActivity
import com.greenovator.padc_end_to_end_kotlin.data.models.PlantModelImp
import com.greenovator.padc_end_to_end_kotlin.mvp.views.DetailView

class DetailPresenter:BasePresenter<DetailView>() {

    fun onUIReady(plantId: Int,activity: DetailActivity){
        if(plantId !=0){
            val model =PlantModelImp
            val plantModel =model.getFindById(plantId)
            plantModel.observe(activity, Observer {
                mView.displayPlantDetail(it)
            })
        }
    }
}
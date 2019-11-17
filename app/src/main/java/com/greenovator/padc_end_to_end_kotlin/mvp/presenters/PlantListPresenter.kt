package com.greenovator.padc_end_to_end_kotlin.mvp.presenters

import androidx.lifecycle.Observer
import com.greenovator.padc_end_to_end_kotlin.activities.DetailActivity
import com.greenovator.padc_end_to_end_kotlin.activities.PlantListActivity
import com.greenovator.padc_end_to_end_kotlin.data.models.PlantModelImp
import com.greenovator.padc_end_to_end_kotlin.delegate.PlantDelegate
import com.greenovator.padc_end_to_end_kotlin.mvp.views.PlantListView

class PlantListPresenter : BasePresenter<PlantListView>(), PlantDelegate {
    override fun onClickLogin(email: String, password: String) {

    }

    override fun onTapPlantItem(id: Int) {
        mView.navigateToNavigate(id)
    }

    fun onUiReady(activity: PlantListActivity){
        val model = PlantModelImp
        model.getPlants { mView.displayError(it) }
            .observe(activity, Observer {
                mView.displayPlantList(it)
            })
    }



}
package com.greenovator.padc_end_to_end_kotlin.mvp.presenters

import com.greenovator.padc_end_to_end_kotlin.data.models.PlantModelImp
import com.greenovator.padc_end_to_end_kotlin.delegate.PlantDelegate
import com.greenovator.padc_end_to_end_kotlin.mvp.views.PlantListView

class PlantListPresenter : BasePresenter<PlantListView>(), PlantDelegate {
    override fun loginAction(email: String, password: String) {

    }

    override fun onTapPlantItem(id: Int) {
        mView.navigateToNavigate(id)
    }


    override fun onCreate() {
        val model = PlantModelImp
        model.getPlants(
            { plants ->
                mView.displayPlantList(plants)
            },
            {
                mView.displayError(it)
            }
        )
    }
}
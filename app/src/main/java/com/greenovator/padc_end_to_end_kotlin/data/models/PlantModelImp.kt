package com.greenovator.padc_end_to_end_kotlin.data.models

import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO
import com.greenovator.padc_end_to_end_kotlin.utils.ERROR_MESSAGE

object PlantModelImp : BaseModel(), PlantModel {
    override fun loginUser(onSuccess: (List<LoginVO>) -> Unit, onFailure: (String) -> Unit) {
        val userFromDB = database.userDao().getUser()
        if (userFromDB.isNotEmpty()){
            onSuccess(userFromDB)
        }else{
            dataAgent.setLogin(
                {
                   // database.userDao().insertUser(it)
                    onSuccess(it)
                },
                {
                    onFailure(it)
                }
            )
        }
    }

    override fun getPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        val plantFromDB = database.plantDao().getAllPlants()
        if (plantFromDB.isNotEmpty()) {
            onSuccess(plantFromDB)
        } else {
            dataAgent.getPlants(
                {
                    database.plantDao().insertPlants(it)
                    onSuccess(it)
                },
                onFailure
            )
        }
    }

    override fun getFindById(id: Int): PlantVO {
        return database.plantDao().getFindById(id)
    }
}
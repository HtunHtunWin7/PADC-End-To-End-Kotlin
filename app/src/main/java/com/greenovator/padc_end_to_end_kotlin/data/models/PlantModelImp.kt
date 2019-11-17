package com.greenovator.padc_end_to_end_kotlin.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
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

    override fun getPlants(onFailure: (String) -> Unit):LiveData<List<PlantVO>>{
        val plantFromDB = database.plantDao().getAllPlants()

            dataAgent.getPlants(
                {
                    database.plantDao().insertPlants(it)
                },
                onFailure
            )
       return plantFromDB
    }

    override fun getFindById(id: Int): LiveData<PlantVO> {
       return database.plantDao().getFindById(id)
    }
}
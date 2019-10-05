package com.greenovator.padc_end_to_end_kotlin.data.models

import android.content.Context
import com.greenovator.padc_end_to_end_kotlin.networks.dataagents.PlantDataAgent
import com.greenovator.padc_end_to_end_kotlin.networks.dataagents.RetrofitDataAgentImp
import com.greenovator.padc_end_to_end_kotlin.persistense.PlantDatabase

open class BaseModel {
    protected var dataAgent: PlantDataAgent = RetrofitDataAgentImp
    protected lateinit var database: PlantDatabase

    fun initDatabase(context: Context){
        database = PlantDatabase.getInstance(context)
    }
}
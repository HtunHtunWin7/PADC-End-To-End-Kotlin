package com.greenovator.padc_end_to_end_kotlin.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.greenovator.padc_end_to_end_kotlin.data.models.PlantModel
import com.greenovator.padc_end_to_end_kotlin.data.models.PlantModelImp

abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var plantModel: PlantModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plantModel = PlantModelImp
    }
}
package com.greenovator.padc_end_to_end_kotlin


import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.greenovator.padc_end_to_end_kotlin.data.models.PlantModelImp

class PlantApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        PlantModelImp.initDatabase(this)
    }

}
package com.greenovator.padc_end_to_end_kotlin.persistense

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO
import com.greenovator.padc_end_to_end_kotlin.persistense.dao.PlantListDao
import com.greenovator.padc_end_to_end_kotlin.persistense.dao.UserDao
import com.greenovator.padc_end_to_end_kotlin.utils.PLANT_DB

@Database(entities = arrayOf(PlantVO::class,LoginVO::class), version = 7, exportSchema = false)
abstract class PlantDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantListDao
    abstract fun userDao(): UserDao

    companion object {
        private var instance: PlantDatabase? = null

        fun getInstance(context: Context): PlantDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, PlantDatabase::class.java, PLANT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            val db = instance!!
            return db
        }
    }
}




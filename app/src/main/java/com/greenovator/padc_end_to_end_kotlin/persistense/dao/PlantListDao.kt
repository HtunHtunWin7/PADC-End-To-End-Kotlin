package com.greenovator.padc_end_to_end_kotlin.persistense.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO

@Dao
abstract class PlantListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPlants(plants: List<PlantVO>): LongArray

    @Query("SELECT * FROM plants")
    abstract fun getAllPlants(): List<PlantVO>

    @Query("SELECT * FROM plants WHERE id=:id")
    abstract fun getFindById(id: Int): PlantVO

    fun arePlantExitInDB():Boolean{
        return getAllPlants().isNotEmpty()
    }

}

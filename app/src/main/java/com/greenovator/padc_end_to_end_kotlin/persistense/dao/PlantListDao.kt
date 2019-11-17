package com.greenovator.padc_end_to_end_kotlin.persistense.dao

import androidx.lifecycle.LiveData
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
    abstract fun getAllPlants(): LiveData<List<PlantVO>>

    @Query("SELECT * FROM plants WHERE id=:id")
    abstract fun getFindById(id: Int): LiveData<PlantVO>


}

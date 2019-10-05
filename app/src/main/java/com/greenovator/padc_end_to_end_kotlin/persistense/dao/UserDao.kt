package com.greenovator.padc_end_to_end_kotlin.persistense.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO

@Dao
abstract class UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(user: List<LoginVO>)

    @Query("SELECT * FROM user")
    abstract fun getUser(): List<LoginVO>

    fun isUserExit(): Boolean{
        return getUser().isNotEmpty()
    }
}
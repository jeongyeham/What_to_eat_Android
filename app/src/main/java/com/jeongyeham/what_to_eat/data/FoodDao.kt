package com.jeongyeham.what_to_eat.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.jeongyeham.what_to_eat.model.Food

@Dao
interface FoodDao {
    @Query("SELECT * FROM foods")
    suspend fun getAllFoods(): List<Food>

    @Insert
    suspend fun insertFood(food: Food)

    @Update
    suspend fun updateFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)

    @Query("DELETE FROM foods")
    suspend fun deleteAllFoods()
}
package com.jeongyeham.what_to_eat.data

import com.jeongyeham.what_to_eat.model.Food

class FoodRepository(private val foodDao: FoodDao) {
    suspend fun getAllFoods(): List<Food> = foodDao.getAllFoods()

    suspend fun insertFood(food: Food) = foodDao.insertFood(food)

    suspend fun updateFood(food: Food) = foodDao.updateFood(food)

    suspend fun deleteFood(food: Food) = foodDao.deleteFood(food)

    suspend fun deleteAllFoods() = foodDao.deleteAllFoods()
}
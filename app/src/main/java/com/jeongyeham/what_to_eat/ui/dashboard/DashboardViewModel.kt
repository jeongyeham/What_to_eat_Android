package com.jeongyeham.what_to_eat.ui.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jeongyeham.what_to_eat.data.FoodDatabase
import com.jeongyeham.what_to_eat.data.FoodRepository
import com.jeongyeham.what_to_eat.model.Food
import kotlinx.coroutines.launch

class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FoodRepository

    private val _foodList = MutableLiveData<List<Food>>()
    val foodList: LiveData<List<Food>> = _foodList

    init {
        val foodDao = FoodDatabase.getDatabase(application).foodDao()
        repository = FoodRepository(foodDao)
        loadFoods()
    }

    private fun loadFoods() {
        viewModelScope.launch {
            _foodList.value = repository.getAllFoods()
        }
    }

    fun addFood(name: String) {
        if (name.isNotBlank()) {
            viewModelScope.launch {
                repository.insertFood(Food(name = name))
                loadFoods()
            }
        }
    }

    fun deleteFood(food: Food) {
        viewModelScope.launch {
            repository.deleteFood(food)
            loadFoods()
        }
    }
}
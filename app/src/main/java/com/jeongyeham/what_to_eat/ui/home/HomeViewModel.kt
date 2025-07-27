package com.jeongyeham.what_to_eat.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jeongyeham.what_to_eat.data.FoodDatabase
import com.jeongyeham.what_to_eat.data.FoodRepository
import com.jeongyeham.what_to_eat.model.Food
import kotlinx.coroutines.launch
import kotlin.random.Random

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FoodRepository
    private val _text = MutableLiveData<String>().apply {
        value = "今天吃什么?"
    }
    val text: LiveData<String> = _text

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    init {
        val foodDao = FoodDatabase.getDatabase(application).foodDao()
        repository = FoodRepository(foodDao)
    }

    fun chooseFood() {
        viewModelScope.launch {
            val foods = repository.getAllFoods()
            if (foods.isEmpty()) {
                _result.value = "请先添加食物"
            } else {
                val randomIndex = Random.nextInt(foods.size)
                _result.value = foods[randomIndex].name
            }
        }
    }
}
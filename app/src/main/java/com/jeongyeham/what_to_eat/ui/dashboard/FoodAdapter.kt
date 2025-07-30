package com.jeongyeham.what_to_eat.ui.dashboard

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jeongyeham.what_to_eat.R
import com.jeongyeham.what_to_eat.model.Food

class FoodAdapter(
    private var foods: List<Food>,
    private val onDeleteClick: (Food) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodNameTextView: TextView = itemView.findViewById(R.id.text_view_food_name)
        val deleteButton: Button = itemView.findViewById(R.id.button_delete_food)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.foodNameTextView.text = food.name
        holder.deleteButton.setOnClickListener {
            onDeleteClick(food)
        }
    }

    override fun getItemCount(): Int = foods.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateFoods(newFoods: List<Food>) {
        foods = newFoods
        notifyDataSetChanged()
    }
}
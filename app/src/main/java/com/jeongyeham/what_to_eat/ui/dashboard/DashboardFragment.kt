package com.jeongyeham.what_to_eat.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jeongyeham.what_to_eat.databinding.FragmentDashboardBinding
import com.jeongyeham.what_to_eat.ui.dashboard.FoodAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupClickListeners()

        // 观察食物列表变化
        dashboardViewModel.foodList.observe(viewLifecycleOwner) { foods ->
            foodAdapter.updateFoods(foods)
        }

        return root
    }

    private fun setupRecyclerView() {
        foodAdapter = FoodAdapter(emptyList()) { food ->
            dashboardViewModel.deleteFood(food)
        }

        binding.recyclerViewFoods.apply {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setupClickListeners() {
        binding.buttonAddFood.setOnClickListener {
            val foodName = binding.editTextFoodName.text.toString().trim()
            if (foodName.isNotEmpty()) {
                dashboardViewModel.addFood(foodName)
                binding.editTextFoodName.text.clear()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.jeongyeham.what_to_eat.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jeongyeham.what_to_eat.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val aboutViewModel =
            ViewModelProvider(this).get(AboutViewModel::class.java)

        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAbout
        // 设置作者名字
        textView.text = "作者：Jeongye Ham\n\n这是一个帮助你决定吃什么的应用程序。"

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
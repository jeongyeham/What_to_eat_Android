package com.jeongyeham.what_to_eat.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jeongyeham.what_to_eat.R
import com.jeongyeham.what_to_eat.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    // 点击计数器
    private var clickCount = 0
    // 显示头像需要的点击次数
    private val requiredClicks = 5

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAbout
        // 只显示作者名字
        textView.text = getString(R.string.app_author_name)
        
        // 设置点击监听器
        textView.setOnClickListener {
            clickCount++
            if (clickCount >= requiredClicks) {
                showAvatar()
            }
        }

        return root
    }

    private fun showAvatar() {
        val avatarImageView: ImageView = binding.imageAvatar
        // 显示头像（使用应用图标作为示例）
        avatarImageView.setImageResource(R.drawable.avatar)
        avatarImageView.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
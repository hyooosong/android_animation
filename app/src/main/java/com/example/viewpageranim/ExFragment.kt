package com.example.viewpageranim

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.viewpageranim.databinding.FragmentExBinding

class ExFragment(private val position: Int) : Fragment() {
    private lateinit var binding : FragmentExBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ex, container, false)
        initViewPager()
        return binding.root
    }

    private fun initViewPager() {
        when(position) {
            0 -> {
                binding.view.setBackgroundColor(Color.parseColor("#f3aa12"))
                binding.view.clipToOutline = true
            }
            1 -> binding.view.setBackgroundColor(Color.parseColor("#9ae2f2"))
            2 -> binding.view.setBackgroundColor(Color.parseColor("#b1ea22"))
        }
    }
}
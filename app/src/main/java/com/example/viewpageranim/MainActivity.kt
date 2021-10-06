package com.example.viewpageranim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpageranim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setVPAdapter()
    }

    private fun setVPAdapter() {
        binding.viewPagerMain.apply {
            adapter = ScreenSlidePagerAdapter(this@MainActivity)
            offscreenPageLimit = 1
            setPageTransformer(DepthPageTransformer(1))
        }
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES
        override fun createFragment(position: Int): Fragment = ExFragment(position)
    }

    companion object {
        private const val NUM_PAGES = 3
    }
}
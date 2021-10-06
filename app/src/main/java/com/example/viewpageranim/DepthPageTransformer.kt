package com.example.viewpageranim

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs

class DepthPageTransformer(private val offscreenPageLimit: Int) : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.apply {
            val scaleFactor = (MIN_SCALE + (1 - MIN_SCALE) * (1 - abs(position)))

            when {
                position <= offscreenPageLimit - 1 -> {
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                    translationY = -(height / DEFAULT_TRANSLATION_FACTOR) * position
                }
                else -> {
                    translationY = DEFAULT_TRANSLATION_Y
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                }
            }
            alpha = DEFAULT_ALPHA + position
        }
    }

    companion object {
        private const val DEFAULT_TRANSLATION_Y = .0f
        private const val DEFAULT_TRANSLATION_FACTOR = 1.1f

        private const val DEFAULT_SCALE = 1f
        private const val MIN_SCALE = 0.75f

        private const val DEFAULT_ALPHA = 1f
    }
}
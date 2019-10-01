package com.example.collapsinglayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.palette.graphics.Palette
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.appbar.AppBarLayout
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app_bar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var isShow = true
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    tv_ttile!!.text="Header title"

                    isShow = true
                } else if (isShow) {
                    isShow = false
                    tv_ttile!!.text=""//careful there should a space between double quote otherwise it wont work
                }
                tv_ttile!!.alpha=Math.abs(verticalOffset.toFloat())
                Log.e("test","tv_ttile"+verticalOffset)
            }
        })
    }
}

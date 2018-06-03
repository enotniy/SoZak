package com.enotniy.sozak

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent



/**
 *Created by ekitselyuk on 04/06/2018
 */
class StaticViewPager @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null) :
        ViewPager(context, attrs) {

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return false
    }
}
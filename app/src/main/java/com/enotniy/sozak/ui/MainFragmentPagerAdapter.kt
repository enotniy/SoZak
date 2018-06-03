package com.enotniy.sozak.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.enotniy.sozak.ui.purchases.PurchasesFragment
import android.view.MotionEvent



/**
 *Created by ekitselyuk on 04/06/2018
 */
class MainFragmentPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> PurchasesFragment()
                1 -> GroupsFragment()
                2 -> AttachmentsFragment()
                3 -> ProfileFragment()
                else -> Fragment()
            }

    override fun getCount(): Int = 4


}
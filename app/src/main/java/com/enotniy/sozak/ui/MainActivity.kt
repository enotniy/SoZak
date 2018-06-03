package com.enotniy.sozak.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.enotniy.sozak.R
import com.vk.sdk.api.*
import com.vk.sdk.api.model.VKApiCommunityArray
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                pager.setCurrentItem(0, false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_groups -> {
                pager.setCurrentItem(1, false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_attachments -> {
                pager.setCurrentItem(2, false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                pager.setCurrentItem(3, false)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        pager.adapter = MainFragmentPagerAdapter(supportFragmentManager)
    }

    private fun loadGroups() {
        VKApi.groups().get(VKParameters.from(VKApiConst.EXTENDED, 1, VKApiConst.FILTERS, "admin"))
                .executeWithListener(object : VKRequest.VKRequestListener() {
                    override fun onComplete(response: VKResponse?) {
                        super.onComplete(response)

                        response?.let { data ->
                            Log.d("VKRequest", data.json.toString())

                            val groups = data.parsedModel as VKApiCommunityArray
                        }
                    }
                })
    }

}

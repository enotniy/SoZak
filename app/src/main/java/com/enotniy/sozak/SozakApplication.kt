package com.enotniy.sozak

import android.app.Application
import com.marcinmoskala.kotlinpreferences.PreferenceHolder
import com.vk.sdk.VKSdk

/**
 *Created by ekitselyuk on 31/05/2018
 */

class SozakApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        VKSdk.initialize(this)
        PreferenceHolder.setContext(applicationContext)
    }
}
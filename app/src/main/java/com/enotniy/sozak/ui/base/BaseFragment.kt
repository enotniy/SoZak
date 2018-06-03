package com.enotniy.sozak.ui.base

import android.content.Context
import android.support.v4.app.Fragment

/**
 *Created by ekitselyuk on 04/06/2018
 */
open class BaseFragment: Fragment() {

    fun context(): Context = context!!

}
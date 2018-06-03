package com.enotniy.sozak.ui.purchases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enotniy.sozak.R
import com.enotniy.sozak.ui.base.BaseFragment

class PurchasesFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_purchases, container, false)
    }


}

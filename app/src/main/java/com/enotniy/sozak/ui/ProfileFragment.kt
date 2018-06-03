package com.enotniy.sozak.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enotniy.sozak.R
import com.enotniy.sozak.extensions.loadImage
import com.enotniy.sozak.extensions.toSingle
import com.enotniy.sozak.ui.base.BaseFragment
import com.vk.sdk.api.VKApi
import com.vk.sdk.api.VKApiConst
import com.vk.sdk.api.VKParameters
import com.vk.sdk.api.model.VKApiUser
import com.vk.sdk.api.model.VKApiUserFull
import com.vk.sdk.api.model.VKList
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        VKApi.users()
                .get(VKParameters.from(VKApiConst.FIELDS, "photo_50, photo_100, photo_200"))
                .toSingle<VKList<VKApiUserFull>>().subscribeBy(
                onSuccess = { users ->
                    users.firstOrNull()?.let { user ->
                        context().loadImage(profile_photo, user.photo_100, R.drawable.ic_person_black_24dp)
                        username.text = "${user.first_name} ${user.last_name}"
                    }
                }
        )
    }
}

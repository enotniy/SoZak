package com.enotniy.sozak.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.enotniy.sozak.R
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.startActivity

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        VKAccessToken.currentToken()?.let { _ ->
            start()
        } ?: VKSdk.login(this, VKScope.GROUPS, VKScope.PHOTOS, VKScope.OFFLINE, VKScope.EMAIL)
    }

    fun start() {
        Handler().postDelayed({
            startActivity<MainActivity>()
        }, 3000)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
            override fun onResult(res: VKAccessToken) {
                res.save()
                start()
            }

            override fun onError(error: VKError) {
                alert {

                    title = getString(R.string.no_auth)

                    okButton {
                        finish()
                    }
                }
            }
        })
        super.onActivityResult(requestCode, resultCode, data)
    }

}

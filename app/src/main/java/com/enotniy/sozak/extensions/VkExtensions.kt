package com.enotniy.sozak.extensions

import com.vk.sdk.api.VKError
import com.vk.sdk.api.VKRequest
import com.vk.sdk.api.VKResponse
import com.vk.sdk.api.model.VKApiModel
import io.reactivex.Single

/**
 *Created by ekitselyuk on 04/06/2018
 */

fun <T : VKApiModel> VKRequest.toSingle(): Single<T> {
    return Single.create { emitter ->
        this.executeWithListener(object : VKRequest.VKRequestListener() {

            override fun onComplete(response: VKResponse) {
                super.onComplete(response)
                emitter.onSuccess(response.parsedModel as T)
            }

            override fun onError(error: VKError) {
                super.onError(error)
                emitter.onError(error.httpError)
            }
        })
    }
}
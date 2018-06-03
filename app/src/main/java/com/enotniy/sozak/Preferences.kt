package com.enotniy.sozak

import com.marcinmoskala.kotlinpreferences.PreferenceHolder

/**
 *Created by ekitselyuk on 31/05/2018
 */

object Preferences: PreferenceHolder() {
    var vkToken: String? by bindToPreferenceFieldNullable(null)
}
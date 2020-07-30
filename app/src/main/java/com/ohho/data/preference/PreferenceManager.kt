/*
 * *
 *  * Created by Nethaji on 27/6/20 1:17 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 27/6/20 1:17 PM
 *
 */

package com.mespace.data.preference

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(private val context: Context) : IPreferenceManager {

    val pref: SharedPreferences =
        context.getSharedPreferences("community_app_preference", Context.MODE_PRIVATE)



    override fun setUserId(userId: String?) =
        pref.edit().putString(USER_ID, userId.toString()).apply()

    override fun getUserId(): String = pref.getString(USER_ID, "").toString()

    override fun setMobileNumber(mobileNo: String?) =
        pref.edit().putString(MOBILE_NUMBER, mobileNo.toString()).apply()


    override fun getMobileNumber(): String = pref.getString(MOBILE_NUMBER, "").toString()

    companion object {

        const val USER_ID = "user_id"
        const val MOBILE_NUMBER = "mobile_number"

    }
}



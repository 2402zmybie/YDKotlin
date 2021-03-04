package com.hr.ydkotlin.ui.fragment

import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hr.ydkotlin.R
import com.hr.ydkotlin.ui.activity.AboutActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SettingFragment:PreferenceFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        addPreferencesFromResource(R.xml.settings_prefs)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPreferenceTreeClick(preferenceScreen: PreferenceScreen?, preference: Preference?): Boolean {
        when(preference?.key) {
            "about" -> activity.startActivity<AboutActivity>()
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }
}
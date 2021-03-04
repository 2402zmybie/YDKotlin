package com.hr.ydkotlin.util

import com.hr.ydkotlin.R
import com.hr.ydkotlin.base.BaseFragment
import com.hr.ydkotlin.ui.fragment.HomeFragment
import com.hr.ydkotlin.ui.fragment.MvFragment
import com.hr.ydkotlin.ui.fragment.VBangFragment
import com.hr.ydkotlin.ui.fragment.YueDanFragment


//单例Fragment管理类
class FragmentUtil private constructor(){
    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vbangFragment by lazy { VBangFragment() }
    val yueDanFragment by lazy { YueDanFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    fun getFragment(tabId:Int): BaseFragment? {
        when (tabId) {
            R.id.tab_home -> return homeFragment
            R.id.tab_mv -> return mvFragment
            R.id.tab_vlist -> return vbangFragment
            R.id.tab_yue_dan -> return yueDanFragment
        }
        return null
    }
}
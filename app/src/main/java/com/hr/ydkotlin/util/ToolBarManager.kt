package com.hr.ydkotlin.util

import android.annotation.SuppressLint
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.hr.ydkotlin.R
import com.hr.ydkotlin.ui.activity.SettingActivity
import org.jetbrains.anko.startActivity

interface ToolBarManager {
    val toolbar: Toolbar
    /**
     * 初始化主页面中toolbar
     */
    fun initMainToolBar() {
        toolbar.setTitle("卖座影音")
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when(it?.itemId) {
                //跳转设置界面
                R.id.setting -> toolbar.context.startActivity<SettingActivity>();
            }
            true
        }
//        toolbar.setOnMenuItemClickListener(object :MenuItem.OnMenuItemClickListener, Toolbar.OnMenuItemClickListener {
//            override fun onMenuItemClick(item: MenuItem?): Boolean {
//                when(item?.itemId) {
//                    //跳转设置界面
//                    R.id.setting -> toolbar.context.startActivity<SettingActivity>();
//                }
//                return true;
//            }
//
//        })
    }

    fun initSettingToolbar() {
        toolbar.setTitle("设置")
    }
}
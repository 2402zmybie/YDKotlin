package com.hr.ydkotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.widget.Toolbar
import com.hr.ydkotlin.R
import com.hr.ydkotlin.base.BaseActivity
import com.hr.ydkotlin.util.ToolBarManager
import org.jetbrains.anko.debug
import org.jetbrains.anko.find

class SettingActivity : BaseActivity(),ToolBarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int  = R.layout.activity_setting

    override fun initData() {
        initSettingToolbar()
        //获取推送通知有没有被选中
        var sp = PreferenceManager.getDefaultSharedPreferences(this)
        var push = sp.getBoolean("push", false)
        debug { "$push" }
    }
}

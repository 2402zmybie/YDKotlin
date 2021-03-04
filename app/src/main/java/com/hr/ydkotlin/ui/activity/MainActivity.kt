package com.hr.ydkotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.hr.ydkotlin.R
import com.hr.ydkotlin.base.BaseActivity
import com.hr.ydkotlin.util.FragmentUtil
import com.hr.ydkotlin.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity() ,ToolBarManager{
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
        initMainToolBar()
    }

    override fun initListener() {
        //设置BottomBar切换监听
        bottomBar.setOnTabSelectListener {
            var fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(it)!!, it.toString())
            fragmentTransaction.commit()
        }
    }
}

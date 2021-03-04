package com.hr.ydkotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.toast

abstract class BaseActivity:AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener();
        initData();

    }

    protected fun initData() {
    }

    protected fun initListener() {
    }


    /**
     * 获取布局id
     */
    abstract fun getLayoutId(): Int


    protected fun myToast(msg:String) {
        runOnUiThread { toast(msg) }
    }


}
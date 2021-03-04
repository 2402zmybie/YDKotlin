package com.hr.ydkotlin.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.hr.ydkotlin.R
import com.hr.ydkotlin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment :BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home,null);
    }

    override fun initListener() {
        //初始化recyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        //适配
    }

}
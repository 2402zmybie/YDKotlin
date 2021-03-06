package com.hr.ydkotlin.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.hr.ydkotlin.R
import com.hr.ydkotlin.adapter.HomeAdapter
import com.hr.ydkotlin.base.BaseFragment
import com.hr.ydkotlin.model.HomeItemBean
import com.hr.ydkotlin.util.ThreadUtil
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomeFragment :BaseFragment() {
    val adapter by lazy { HomeAdapter() }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home,null);
    }

    override fun initListener() {
        //初始化recyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        //适配
        recyclerView.adapter = adapter;
        //初始化刷新控价
        refreshLayout.setColorSchemeColors(Color.RED,Color.YELLOW,Color.GREEN)
        //刷新监听
        refreshLayout.setOnRefreshListener {
            loadData()
        }
    }

    override fun initData() {
        loadData()
    }

    private fun loadData() {
        var offset = 0;
        var size = 10;
        val path = "http://www.liulongbin.top:3005/api/v2/movie/in_theaters?start=$offset&count=$size";
        //发送网络请求
        var client = OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build();
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                println("获取数据出错" + e.message)
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        refreshLayout.isRefreshing = false;
                    }
                })
            }

            override fun onResponse(call: Call, response: Response) {
                myToast("获取数据成功")
                var result = response?.body()?.string()
                var gson = Gson()
                var homeItemBean = gson.fromJson<HomeItemBean>(result, HomeItemBean::class.java)
                println("获取数据成功" + homeItemBean.subjects.size)
                //刷新列表
                ThreadUtil.runOnMainThread(object :Runnable {
                    override fun run() {
                        adapter.updateList(homeItemBean.subjects)
                        refreshLayout.isRefreshing = false;
                    }
                })
            }
        })
    }

}
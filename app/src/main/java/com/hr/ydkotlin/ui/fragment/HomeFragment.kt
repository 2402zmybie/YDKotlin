package com.hr.ydkotlin.ui.fragment

import android.view.View
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
    var offset = 0;
    var size = 10;

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home,null);
    }

    override fun initListener() {
        //初始化recyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        //适配
        recyclerView.adapter = adapter;
        //刷新
        refreshLayout.setOnRefreshListener {
            offset = 0;
            loadData(true)
        }
        refreshLayout.setOnLoadMoreListener {
            offset = (offset + 1)*size;
            loadData(false)
        }
    }

    override fun initData() {
        loadData(true)
    }

    private fun loadData(refresh: Boolean) {
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
                        refreshLayout.finishRefresh();  //刷新完成
                    }
                })
            }

            override fun onResponse(call: Call, response: Response) {
                myToast("获取数据成功")
                var result = response?.body()?.string()
                var gson = Gson()
                var homeItemBean = gson.fromJson<HomeItemBean>(result, HomeItemBean::class.java)
                println("获取数据成功" + homeItemBean.subjects.size)
                if(refresh) {
                    //刷新列表
                    ThreadUtil.runOnMainThread(object :Runnable {
                        override fun run() {
                            adapter.updateList(homeItemBean.subjects)
                            refreshLayout.finishRefresh();  //刷新完成
                        }
                    })
                }else {
                    if(homeItemBean.subjects.size ==0) {
                        myToast("没有更多数据了")
                        ThreadUtil.runOnMainThread(object :Runnable {
                            override fun run() {
                                refreshLayout.finishLoadMoreWithNoMoreData();
                            }
                        })
                    }else {
                        //加载更多
                        ThreadUtil.runOnMainThread(object :Runnable {
                            override fun run() {
                                adapter.loadMore(homeItemBean.subjects)
                                refreshLayout.finishLoadMore(); //加载更多完成
                            }
                        })
                    }
                }
            }
        })
    }

}
package com.hr.ydkotlin.presenter.impl

import com.google.gson.Gson
import com.hr.ydkotlin.model.HomeItemBean
import com.hr.ydkotlin.presenter.interf.HomePresenter
import com.hr.ydkotlin.util.ThreadUtil
import com.hr.ydkotlin.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomePresenterImpl(var homeView:HomeView): HomePresenter {
    var offset = 0;
    var size = 10;

    override fun loadData(refresh: Boolean) {
        if(refresh) {
            offset = 0;
        }else {
            offset = (offset + 1)*size;
        }
        val path = "http://www.liulongbin.top:3005/api/v2/movie/in_theaters?start=$offset&count=$size";
        //发送网络请求
        var client = OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build();
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        //回调到view层进行处理
                        homeView.onError(e.message)
                    }
                })
            }

            override fun onResponse(call: Call, response: Response) {
                var result = response?.body()?.string()
                var gson = Gson()
                var homeItemBean = gson.fromJson<HomeItemBean>(result, HomeItemBean::class.java)
                if(refresh) {
                    //刷新列表
                    ThreadUtil.runOnMainThread(object :Runnable {
                        override fun run() {
                            homeView.onRefreshSuccess(homeItemBean.subjects)
                        }
                    })
                }else {
                    if(homeItemBean.subjects.size ==0) {
                        ThreadUtil.runOnMainThread(object :Runnable {
                            override fun run() {
                                homeView.onLoadNoMoreData()

                            }
                        })
                    }else {
                        //加载更多
                        ThreadUtil.runOnMainThread(object :Runnable {
                            override fun run() {
                                homeView.onLoadMoreSuccess(homeItemBean.subjects)
                            }
                        })
                    }
                }
            }
        })
    }
}


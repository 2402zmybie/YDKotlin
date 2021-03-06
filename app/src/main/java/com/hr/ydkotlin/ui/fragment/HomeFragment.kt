package com.hr.ydkotlin.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.hr.ydkotlin.R
import com.hr.ydkotlin.adapter.HomeAdapter
import com.hr.ydkotlin.base.BaseFragment
import com.hr.ydkotlin.model.HomeItemBean
import com.hr.ydkotlin.model.Subject
import com.hr.ydkotlin.presenter.impl.HomePresenterImpl
import com.hr.ydkotlin.util.ThreadUtil
import com.hr.ydkotlin.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomeFragment :BaseFragment(), HomeView {
    val adapter by lazy { HomeAdapter() }
    val presenter by lazy { HomePresenterImpl(this) }


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
            presenter.loadData(true)
        }
        refreshLayout.setOnLoadMoreListener {
            presenter.loadData(false)
        }
    }

    override fun initData() {
        presenter.loadData(true)
    }

    override fun onRefreshSuccess(subjects: List<Subject>) {
        adapter.updateList(subjects);
        refreshLayout.finishRefresh();  //刷新完成
    }

    override fun onLoadNoMoreData() {
        myToast("没有更多数据了")
        refreshLayout.finishLoadMoreWithNoMoreData();
    }

    override fun onLoadMoreSuccess(subjects: List<Subject>) {
        adapter.loadMore(subjects);
        refreshLayout.finishLoadMore(); //加载更多完成
    }

    override fun onError(message: String?) {
        refreshLayout.finishRefresh();  //刷新完成
        refreshLayout.finishLoadMore()  //加载完成
    }


}
package com.hr.ydkotlin.base

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hr.ydkotlin.R
import kotlinx.android.synthetic.main.fragment_home.*

abstract class BaseListFragment<ITEMBEAN,ITEMVIEW:View>:BaseFragment(), BaseView<ITEMBEAN> {

    //适配器
    val adapter by lazy { getSpecialAdapter() }
    abstract fun getSpecialAdapter():BaseListAdapter<ITEMBEAN,ITEMVIEW>

    val presenter by lazy { getSpecialPresenter() }
    abstract fun getSpecialPresenter():BaseListPresenter

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null);
    }



    override fun initListener() {
        recyclerView.layoutManager = LinearLayoutManager(context);
        recyclerView.adapter = adapter;
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

    override fun onRefreshSuccess(subjects: List<ITEMBEAN>) {
        adapter.updateList(subjects);
        refreshLayout.finishRefresh();  //刷新完成
    }

    override fun onLoadNoMoreData() {
        myToast("没有更多数据了")
        refreshLayout.finishLoadMoreWithNoMoreData();
    }

    override fun onLoadMoreSuccess(subjects: List<ITEMBEAN>) {
        adapter.loadMore(subjects);
        refreshLayout.finishLoadMore(); //加载更多完成
    }

    override fun onError(message: String?) {
        refreshLayout.finishRefresh();  //刷新完成
        refreshLayout.finishLoadMore()  //加载完成
    }


    override fun onDestroyView() {
        super.onDestroyView()
        //解绑presenter
        presenter.destoryView()
    }

}

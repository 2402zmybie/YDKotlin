package com.hr.ydkotlin.base

import com.hr.ydkotlin.model.Subject

/**
 * 所有下拉刷新和上拉加载更多列表界面的view基类
 */
interface BaseView<ITEMBEAN> {

    fun onRefreshSuccess(subjects: List<ITEMBEAN>)
    fun onLoadNoMoreData()
    fun onLoadMoreSuccess(subjects: List<ITEMBEAN>)
    fun onError(message: String?)
}
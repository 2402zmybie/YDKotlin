package com.hr.ydkotlin.base

/**
 * 所有下拉刷新和上拉加载更多列表界面presenter的基类
 */
interface BaseListPresenter {
    fun loadData(refresh: Boolean)

    //解绑presenter和view
    fun destoryView();
}
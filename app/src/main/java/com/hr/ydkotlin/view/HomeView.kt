package com.hr.ydkotlin.view

import com.hr.ydkotlin.model.Subject

/**
 * home界面和presenter交互的接口
 */
interface HomeView {
    fun onRefreshSuccess(subjects: List<Subject>)
    fun onLoadNoMoreData()
    fun onLoadMoreSuccess(subjects: List<Subject>)
    fun onError(message: String?)
}
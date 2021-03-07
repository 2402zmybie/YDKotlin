package com.hr.ydkotlin.presenter.impl

import com.hr.ydkotlin.base.BaseView
import com.hr.ydkotlin.model.HomeItemBean
import com.hr.ydkotlin.model.Subject
import com.hr.ydkotlin.net.ResponseHandler
import com.hr.ydkotlin.net.YueDanRequest
import com.hr.ydkotlin.presenter.interf.YueDanPresenter
import com.hr.ydkotlin.view.YueDanView

class YueDanPresenterImpl(var yueDanView: BaseView<Subject>?):YueDanPresenter {

    var offset = 0;
    var size = 10;

    override fun loadData(refresh: Boolean) {
        if(refresh) {
            offset = 0;
        }else {
            offset = (offset + 1)*size;
        }
        val path = "http://www.liulongbin.top:3005/api/v2/movie/top250?start=$offset&count=$size";
        YueDanRequest(
            path,
            object :ResponseHandler<HomeItemBean> {
                override fun onError(msg: String?) {
                    yueDanView?.onError(msg)
                }

                override fun onSuccess(homeItemBean: HomeItemBean) {
                    if(refresh) {
                        //刷新列表
                        yueDanView?.onRefreshSuccess(homeItemBean.subjects)
                    }else {
                        if(homeItemBean.subjects.size ==0) {
                            yueDanView?.onLoadNoMoreData()
                        }else {
                            //加载更多
                            yueDanView?.onLoadMoreSuccess(homeItemBean.subjects)
                        }
                    }
                }

            }
        ).excute()
    }

    override fun destoryView() {
        if(yueDanView != null) {
            yueDanView = null
        }
    }


}
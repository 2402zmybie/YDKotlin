package com.hr.ydkotlin.ui.fragment

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.hr.ydkotlin.R
import com.hr.ydkotlin.adapter.YueDanAdapter
import com.hr.ydkotlin.base.BaseFragment
import com.hr.ydkotlin.base.BaseListAdapter
import com.hr.ydkotlin.base.BaseListFragment
import com.hr.ydkotlin.base.BaseListPresenter
import com.hr.ydkotlin.model.Subject
import com.hr.ydkotlin.presenter.impl.YueDanPresenterImpl
import com.hr.ydkotlin.view.YueDanView
import com.hr.ydkotlin.widget.YueDanItemView
import kotlinx.android.synthetic.main.fragment_home.*

class YueDanFragment :BaseListFragment<Subject,YueDanItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<Subject, YueDanItemView> {
        return YueDanAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return YueDanPresenterImpl(this)
    }


}
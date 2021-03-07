package com.hr.ydkotlin.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hr.ydkotlin.R
import com.hr.ydkotlin.adapter.HomeAdapter
import com.hr.ydkotlin.base.BaseFragment
import com.hr.ydkotlin.base.BaseListAdapter
import com.hr.ydkotlin.base.BaseListFragment
import com.hr.ydkotlin.base.BaseListPresenter
import com.hr.ydkotlin.model.Subject
import com.hr.ydkotlin.presenter.impl.HomePresenterImpl
import com.hr.ydkotlin.view.HomeView
import com.hr.ydkotlin.widget.HomeItemView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment :BaseListFragment<Subject,HomeItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<Subject, HomeItemView> {
        return HomeAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return HomePresenterImpl(this)
    }



}
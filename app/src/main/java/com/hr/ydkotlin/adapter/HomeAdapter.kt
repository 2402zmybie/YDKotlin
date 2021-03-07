package com.hr.ydkotlin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hr.ydkotlin.base.BaseListAdapter
import com.hr.ydkotlin.model.HomeItemBean
import com.hr.ydkotlin.model.Subject
import com.hr.ydkotlin.widget.HomeItemView

class HomeAdapter: BaseListAdapter<Subject, HomeItemView>() {


    override fun refreshItemView(itemView: HomeItemView, data: Subject) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }

}

package com.hr.ydkotlin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hr.ydkotlin.base.BaseListAdapter
import com.hr.ydkotlin.model.Subject
import com.hr.ydkotlin.widget.YueDanItemView

class YueDanAdapter: BaseListAdapter<Subject, YueDanItemView>(){

    override fun refreshItemView(itemView: YueDanItemView, data: Subject) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): YueDanItemView {
        return YueDanItemView(context)
    }

}
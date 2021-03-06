package com.hr.ydkotlin.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hr.ydkotlin.model.HomeItemBean
import com.hr.ydkotlin.model.Subject
import com.hr.ydkotlin.widget.HomeItemView

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    private var list = ArrayList<Subject>();

    /**
     * 更新数据
     */
    fun updateList(list: List<Subject>) {
        this.list.clear()
        this.list = list as ArrayList<Subject>
        notifyDataSetChanged()
    }

    /**
     * 加载更多
     */
    fun loadMore(list:List<Subject>) {
        this.list.addAll(list);
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        //条目数据
        var subject = list.get(position)
        //条目View
        var homeItemView = holder.itemView as HomeItemView
        //绑定
        homeItemView.setData(subject)
    }


    class HomeHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}

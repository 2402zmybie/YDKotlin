package com.hr.ydkotlin.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hr.ydkotlin.widget.HomeItemView

/**
 * 所有下拉刷新和上拉加载的adapter的基类
 */
abstract class BaseListAdapter<ITEMBEAN,ITEMVIEW:View>: RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {
    private var list = ArrayList<ITEMBEAN>();

    /**
     * 更新数据
     */
    fun updateList(list: List<ITEMBEAN>) {
        this.list.clear()
        this.list = list as ArrayList<ITEMBEAN>
        notifyDataSetChanged()
    }

    /**
     * 加载更多
     */
    fun loadMore(list:List<ITEMBEAN>) {
        this.list.addAll(list);
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListHolder {
        return BaseListHolder(getItemView(parent.context))
    }


    override fun getItemCount(): Int {
        return list.size;
    }

    override fun onBindViewHolder(holder: BaseListHolder, position: Int) {
        //条目数据
        var data = list.get(position)
        //条目View
        var itemView = holder.itemView as ITEMVIEW
        //绑定
        refreshItemView(itemView,data)
    }


    class BaseListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }


    abstract fun refreshItemView(itemView: ITEMVIEW, data: ITEMBEAN)

    abstract fun getItemView(context: Context?): ITEMVIEW

}
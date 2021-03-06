package com.hr.ydkotlin.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.hr.ydkotlin.R
import com.hr.ydkotlin.model.Subject
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class HomeItemView : RelativeLayout {

    //alt + insert (secondary constructor)
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    //调用构造方法 就会执行这个代码块
    init {
        View.inflate(context, R.layout.item_home, this)
    }


    fun setData(subject: Subject) {
        //电影名称
        title.setText(subject.title)
        //简介
        desc.setText(subject.original_title)
        //背景图片
        Picasso.with(context).load(subject.images.small).into(bg)
    }
}
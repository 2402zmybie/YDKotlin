package com.hr.ydkotlin.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.hr.ydkotlin.R
import com.hr.ydkotlin.model.Subject
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_home.view.bg
import kotlinx.android.synthetic.main.item_home.view.title
import kotlinx.android.synthetic.main.item_yuedan.view.*

class YueDanItemView:RelativeLayout {


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_yuedan, this )
    }

    fun setData(subject: Subject) {
        title.setText(subject.title)
        author_name.setText(subject.casts[0].name)
        count.setText((subject.rating.average).toString())
        //演员
        Picasso.get().load(subject.casts[0].avatars.small).transform(CropCircleTransformation()).into(author_img)
        //背景图片
        Picasso.get().load(subject.images.small).into(bg)

    }
}
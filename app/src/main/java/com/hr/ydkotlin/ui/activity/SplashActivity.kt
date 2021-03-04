package com.hr.ydkotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.hr.ydkotlin.R
import com.hr.ydkotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun getLayoutId(): Int  = R.layout.activity_splash;

    override fun initData() {
        ViewCompat.animate(imageView).scaleX(1f).scaleY(1f).setDuration(2000).setListener(this)
    }

    override fun onAnimationEnd(view: View?) {
        //进入主页面
        startActivityAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun onAnimationStart(view: View?) {

    }

}

package com.greenovator.padc_end_to_end_kotlin.mvp.presenters

import com.greenovator.padc_end_to_end_kotlin.mvp.views.BaseView

abstract class BasePresenter<T:BaseView> {
protected lateinit var mView: T
    open fun init(view: T) {
        this.mView = view
    }

    open fun onCreate() {}
    open fun onStart() {}
    open fun onResume() {}
    open fun onPause() {}
    open fun onStop() {}
    open fun onDestroy() {}
}
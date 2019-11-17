package com.greenovator.padc_end_to_end_kotlin.mvp.presenters

import androidx.lifecycle.ViewModel
import com.greenovator.padc_end_to_end_kotlin.mvp.views.BaseView

abstract class BasePresenter<T:BaseView>: ViewModel() {
protected lateinit var mView: T
    open fun init(view: T) {
        this.mView = view
    }

}
package com.greenovator.padc_end_to_end_kotlin.mvp.views

import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO

interface LoginView:BaseView {
    fun loginSuccess(user: List<LoginVO>)
    fun loginFail(errorMessage: String)
    fun alreadyLogin()
}
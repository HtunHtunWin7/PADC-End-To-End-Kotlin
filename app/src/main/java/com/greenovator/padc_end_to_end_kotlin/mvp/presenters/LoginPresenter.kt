package com.greenovator.padc_end_to_end_kotlin.mvp.presenters

import android.content.SharedPreferences
import com.greenovator.padc_end_to_end_kotlin.data.models.PlantModelImp
import com.greenovator.padc_end_to_end_kotlin.delegate.PlantDelegate
import com.greenovator.padc_end_to_end_kotlin.mvp.views.LoginView

class LoginPresenter : BasePresenter<LoginView>(), PlantDelegate {
    private val model = PlantModelImp
    private lateinit var sharedPreferences: SharedPreferences

    override fun onClickLogin(email: String, password: String) {

        model.loginUser(
            { login ->
                mView.loginNavigate(login)
            },
            {
                mView.loginFail(it)
            }
        )

    }
    fun onView(){

    }

    override fun onTapPlantItem(id: Int) {

    }

}
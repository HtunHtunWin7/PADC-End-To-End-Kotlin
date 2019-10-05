package com.greenovator.padc_end_to_end_kotlin.mvp.presenters

import android.content.SharedPreferences
import com.greenovator.padc_end_to_end_kotlin.activities.MainActivity
import com.greenovator.padc_end_to_end_kotlin.data.models.PlantModelImp
import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO
import com.greenovator.padc_end_to_end_kotlin.delegate.PlantDelegate
import com.greenovator.padc_end_to_end_kotlin.mvp.views.LoginView
import com.greenovator.padc_end_to_end_kotlin.utils.GET_PREFERENCE
import retrofit2.http.GET

class LoginPresenter : BasePresenter<LoginView>(), PlantDelegate {
    private val model = PlantModelImp
    private lateinit var sharedPreferences: SharedPreferences

    override fun loginAction(email: String, password: String) {

        model.loginUser(
            { login ->
                mView.loginSuccess(login)
            },
            {
                mView.loginFail(it)
            }
        )

    }

    override fun onCreate() {

    }

    override fun onStart() {
            mView.alreadyLogin()

    }

    override fun onTapPlantItem(id: Int) {

    }

}
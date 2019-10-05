package com.greenovator.padc_end_to_end_kotlin.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.greenovator.padc_end_to_end_kotlin.R
import com.greenovator.padc_end_to_end_kotlin.data.vos.LoginVO
import com.greenovator.padc_end_to_end_kotlin.mvp.presenters.LoginPresenter
import com.greenovator.padc_end_to_end_kotlin.mvp.views.LoginView
import com.greenovator.padc_end_to_end_kotlin.utils.GET_PREFERENCE
import com.greenovator.padc_end_to_end_kotlin.utils.SHAREPREFERENCE
import kotlinx.android.synthetic.main.login.*

class MainActivity : BaseActivity(), LoginView {
    override fun alreadyLogin() {
        //startActivity(Intent(applicationContext, PlantListActivity::class.java))
    }

    public lateinit var sharedPreferences:SharedPreferences
    override fun loginSuccess(user: List<LoginVO>) {
        startActivity(Intent(applicationContext, PlantListActivity::class.java))
        sharedPreferences = this.getSharedPreferences(SHAREPREFERENCE, Context.MODE_PRIVATE)
        val editor =sharedPreferences.edit()
        editor.putInt(GET_PREFERENCE,1)
        editor.apply()
    }


    override fun loginFail(errorMessage: String) {

    }

    private lateinit var mPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = LoginPresenter()
        mPresenter.init(this)


        mPresenter.onCreate()
        /*btn_login.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,PlantListActivity::class.java))
        })*/
       btn_login.setOnClickListener(View.OnClickListener {
            mPresenter.loginAction(
                input_email.text.toString(),
                input_password.text.toString()
            )
        })
        //setSupportActionBar(toolbar)
        mPresenter.onCreate()


    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }*/

    /* override fun onOptionsItemSelected(item: MenuItem): Boolean {
         // Handle action bar item clicks here. The action bar will
         // automatically handle clicks on the Home/Up button, so long
         // as you specify a parent activity in AndroidManifest.xml.
         return when (item.itemId) {
             R.id.action_settings -> true
             else -> super.onOptionsItemSelected(item)
         }
     }*/
}

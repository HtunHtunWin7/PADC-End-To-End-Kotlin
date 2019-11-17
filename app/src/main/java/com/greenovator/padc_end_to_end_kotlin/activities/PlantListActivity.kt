package com.greenovator.padc_end_to_end_kotlin.activities

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Fade
import androidx.transition.Transition
import androidx.transition.TransitionListenerAdapter
import com.greenovator.padc_end_to_end_kotlin.R
import com.greenovator.padc_end_to_end_kotlin.adapters.PlantListAdapter
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO
import com.greenovator.padc_end_to_end_kotlin.delegate.PlantDelegate
import com.greenovator.padc_end_to_end_kotlin.mvp.presenters.PlantListPresenter
import com.greenovator.padc_end_to_end_kotlin.mvp.views.PlantListView
import kotlinx.android.synthetic.main.plant_detail.*
import kotlinx.android.synthetic.main.plant_list.*
import kotlinx.android.synthetic.main.recycler_view.*

class PlantListActivity : BaseActivity(), PlantListView {

    var isChecked: Boolean = false

    override fun displayPlantList(plantList: List<PlantVO>) {
        mAdapter.setNewData(plantList.toMutableList())
    }

    override fun displayError(errorMessage: String) {

    }

    override fun navigateToNavigate(plantId: Int) {
        startActivity(DetailActivity.newIntent(applicationContext, plantId))
    }

    private lateinit var mPresenter: PlantListPresenter
    private lateinit var mAdapter: PlantListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTransition()
        setContentView(R.layout.recycler_view)
        mPresenter = ViewModelProviders.of(this).get(PlantListPresenter::class.java)
        mPresenter.init(this)
        mAdapter = PlantListAdapter(mPresenter)



        with(recycler) {
            recycler.setHasFixedSize(true)
            recycler.layoutManager = LinearLayoutManager(applicationContext)
            recycler.adapter = mAdapter

        }
        mPresenter.onUiReady(this)
    }



    fun setUpTransition() {
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val fade = Fade()
            fade.duration = 2800
            fade.interpolator = AccelerateDecelerateInterpolator()


            fade.addListener(object : TransitionListenerAdapter() {
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    setUpAnimation().start()
                }
            })

            enterTransition = fade
            exitTransition = fade
            setUpListener()

        }
    }

    fun setUpAnimation(): ObjectAnimator {
        recycler.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(
            recycler,
            View.TRANSLATION_X,
            800f,
            recycler.width.toFloat()
        )
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 3200
        return animator
    }

    fun setUpListener(){
        favorite_chip.setOnClickListener {

            if (!isChecked){
                val animator = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
                favorite_chip.startAnimation(animator)
                favorite_chip.speed = 1f
                favorite_chip.playAnimation()
                isChecked = true
            }else {
                favorite_chip.speed = -4.0f
                favorite_chip.playAnimation()
                isChecked = false
            }
        }
    }

}
package com.greenovator.padc_end_to_end_kotlin.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.greenovator.padc_end_to_end_kotlin.R
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO
import com.greenovator.padc_end_to_end_kotlin.mvp.presenters.BasePresenter
import com.greenovator.padc_end_to_end_kotlin.mvp.presenters.DetailPresenter
import com.greenovator.padc_end_to_end_kotlin.mvp.views.DetailView
import kotlinx.android.synthetic.main.plant_detail.*
import kotlinx.android.synthetic.main.plant_detail.user_name
import kotlinx.android.synthetic.main.plant_list.*

class DetailActivity : BaseActivity(), DetailView {
    override fun displayPlantDetail(plantVO: PlantVO) {
        bindData(plantVO)
    }



    private lateinit var mPresenter: DetailPresenter

    companion object {
        const val EXTRA_TO_EXTRA = "Extra_to_Extra"
        fun newIntent(context: Context, moviesIdExtra: Int): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_TO_EXTRA, moviesIdExtra)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plant_detail)

        mPresenter = ViewModelProviders.of(this).get(DetailPresenter::class.java)
        mPresenter.init(this)
        val plantId = intent.getIntExtra(EXTRA_TO_EXTRA, 0);
        mPresenter.onUIReady(plantId,this)

    }

    fun bindData(plantVO: PlantVO) {
        Glide.with(this)
            .load(plantVO.plantPhoto)
            .into(detail_imageView)
        detail_title.text = plantVO.plantName
        detail_paragraph.text = plantVO.description
        if (plantVO.uploadUser.userPhoto!=null)
            Glide.with(this)
                .load(plantVO.uploadUser.userPhoto)
                .into(detail_image_profile)
        user_name.text = "by "+plantVO.uploadUser.name
    }



}
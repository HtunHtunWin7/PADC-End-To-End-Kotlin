package com.greenovator.padc_end_to_end_kotlin.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.greenovator.padc_end_to_end_kotlin.R
import com.greenovator.padc_end_to_end_kotlin.adapters.PlantListAdapter
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO
import com.greenovator.padc_end_to_end_kotlin.delegate.PlantDelegate
import com.greenovator.padc_end_to_end_kotlin.mvp.presenters.PlantListPresenter
import com.greenovator.padc_end_to_end_kotlin.mvp.views.PlantListView
import kotlinx.android.synthetic.main.plant_detail.*
import kotlinx.android.synthetic.main.recycler_view.*

class PlantListActivity : BaseActivity(), PlantListView {

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
        setContentView(R.layout.recycler_view)
        mPresenter = PlantListPresenter()
        mPresenter.init(this)
        mAdapter = PlantListAdapter(mPresenter)



        with(recycler) {
            recycler.setHasFixedSize(true)
            recycler.layoutManager = LinearLayoutManager(applicationContext)
            recycler.adapter = mAdapter

        }

        mPresenter.onCreate()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}
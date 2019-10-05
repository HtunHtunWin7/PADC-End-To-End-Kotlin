package com.greenovator.padc_end_to_end_kotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.greenovator.padc_end_to_end_kotlin.R
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO
import com.greenovator.padc_end_to_end_kotlin.delegate.PlantDelegate
import com.greenovator.padc_end_to_end_kotlin.views.holders.PlantListViewHolder

class PlantListAdapter(private val delegate: PlantDelegate):BaseAdapter<PlantListViewHolder, PlantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_list,parent,false)
        return PlantListViewHolder(view,delegate)
    }
}
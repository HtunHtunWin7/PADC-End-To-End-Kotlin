package com.greenovator.padc_end_to_end_kotlin.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greenovator.padc_end_to_end_kotlin.data.vos.PlantVO
import com.greenovator.padc_end_to_end_kotlin.views.holders.BaseViewHolder

abstract class BaseAdapter<VH : BaseViewHolder<W>, W> : RecyclerView.Adapter<VH>() {
private var dataList: MutableList<W> = ArrayList()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.data = dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setNewData(newData: MutableList<W>)
    {
        dataList = newData
        notifyDataSetChanged()
    }

}
package com.example.naviproject.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.PullRequestEntity

class PullRequestAdapter() : RecyclerView.Adapter<PullRequestViewHolder>() {
    private val listView: ArrayList<PullRequestEntity> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        return PullRequestViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        holder.bind(listView[position] as PullRequestEntity)
    }

    override fun getItemCount(): Int {
        return listView.size
    }

    fun setData(data: List<PullRequestEntity>?) {
        if (data == null) return
        if (listView.isEmpty()) {
            listView.addAll(data)
            notifyItemRangeInserted(0, listView.size)
        }
    }
}

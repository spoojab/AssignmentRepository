package com.example.naviproject.adapter

import com.example.domain.entity.PullRequestEntity
import com.example.naviproject.R
import com.example.naviproject.databinding.ItemPullRequestBinding
import com.example.naviproject.utils.ImageWidgetUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PullRequestViewHolder(val binding: ItemPullRequestBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): PullRequestViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewBinding = ItemPullRequestBinding.inflate(layoutInflater, parent, false)
            return PullRequestViewHolder(viewBinding)
        }
    }

    fun bind(pullRequestEntity: PullRequestEntity) {
        setUserImage(pullRequestEntity.userProfileUrl)
        binding.prTitle.text = pullRequestEntity.title
        binding.closedTitle.text = pullRequestEntity.closedDate
        binding.createdTitle.text = pullRequestEntity.createdDate
        binding.userNameTitle.text = pullRequestEntity.userName
    }

    private fun setUserImage(url: String?) {
        ImageWidgetUtils.loadRoundedImageAsync(
            binding.userDp,
            url,
            R.drawable.default_avatar
        )
    }
}
package com.utad.base.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.utad.base.databinding.ItemRopaBinding
import com.utad.base.model.Ropa


class RopaViewHolder(view: View) : RecyclerView.ViewHolder(view)  {

    val binding=ItemRopaBinding.bind(view)

    fun render(item: Ropa, onClickListener: (Ropa) -> Unit) {
        binding.tvTitle.text = item.title
        Glide.with(binding.ivImage.context)
            .load(item.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.ivImage)

        binding.cvall.setOnClickListener {
            onClickListener(item)
        }
    }
}
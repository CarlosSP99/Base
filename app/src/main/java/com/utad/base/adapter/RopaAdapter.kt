package com.utad.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utad.base.R
import com.utad.base.model.Ropa

class RopaAdapter(
    var ropaList: List<Ropa> = emptyList(),
    private val onClickListener: (Ropa) -> Unit
): RecyclerView.Adapter<RopaViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RopaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ropa, parent, false)
        return RopaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RopaViewHolder, position: Int) {
        val item = ropaList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return ropaList.size    }
}
package com.yeputra.nationalnews.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yeputra.nationalnews.repository.Presiden
import com.yeputra.nationalnews.R
import com.yeputra.nationalnews.base.BaseRecyclerViewAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*

class ListAdapter (
    private val listener: (Presiden) -> Unit
) : BaseRecyclerViewAdapter<ListAdapter.VHolder, Presiden>() {

    override fun onBindViewHolder(holder: VHolder, item: Presiden, position: Int) = holder.binding(item)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VHolder =
        VHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.item_list, p0, false
            ), listener
        )

    class VHolder(
        override val containerView: View,
        val listener: (Presiden) -> Unit
    ) : LayoutContainer, RecyclerView.ViewHolder(containerView) {

        fun binding(data: Presiden) {
            tv_title.text = data.name
            tv_description.text = data.desc

            Glide.with(containerView.context)
                .load(data.photo)
                .apply(RequestOptions().placeholder(R.drawable.ic_person))
                .apply(RequestOptions.circleCropTransform())
                .into(img_photo)
            containerView.setOnClickListener { listener(data) }
        }
    }
}
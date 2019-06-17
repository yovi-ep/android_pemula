package com.yeputra.nationalnews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yeputra.nationalnews.R
import com.yeputra.nationalnews.base.BaseBottomSheetDialogFragment
import com.yeputra.nationalnews.repository.Presiden
import kotlinx.android.synthetic.main.bsheet_choose.*
import kotlinx.android.synthetic.main.bsheet_choose.tv_description
import kotlinx.android.synthetic.main.bsheet_choose.tv_title

class DetailPresidenFm: BaseBottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.bsheet_choose, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            val p: Presiden = it.getParcelable("data") as Presiden
            tv_name.text = p.name
            tv_title.text = p.desc
            tv_description.text = p.detaildesc

            Glide.with(getContextView())
                .load(p.photo)
                .apply(RequestOptions().placeholder(R.drawable.ic_person))
                .apply(RequestOptions.circleCropTransform())
                .into(photo)
        }
    }
}


package com.yeputra.nationalnews.base

import android.content.Context


/**
 * Created by yovi.putra
 *    on 10/Mar/2019 10:31
 * Company SIEMO - PT. Multipolar Technology, Tbk
 */
abstract class BasePresenter(private val activity: IBaseView) : IBasePresenter {

    private val TAG = BasePresenter::class.java.simpleName

    val contextView: Context by lazy { activity.getContextView() }

    override fun onDestroyPresenter() {
    }
}
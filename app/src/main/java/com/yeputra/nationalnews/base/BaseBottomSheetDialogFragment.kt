package com.yeputra.nationalnews.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeputra.nationalnews.R


/**
 * Created by yovi.putra
 *    on 10/Mar/2019 11:23
 * Company SIEMO - PT. Multipolar Technology, Tbk
 */

abstract class BaseBottomSheetDialogFragment
    : BottomSheetDialogFragment(), IBaseView {

    private lateinit var activity: IBaseView

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            Log.d(TAG, "Get context from fragment attach")
            activity = it as IBaseView
        }?: run{
            Log.d(TAG, "Get context from super")
            activity = this
        }
    }

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.bsheet_choose, container, false)

    override fun getContextView(): Context = context as Context

    override fun onPresenterSuccess(data: Any?) {
        Log.d(TAG, "onPresenterSuccess")
    }

    override fun onPresenterFailed(message: String?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


    override fun onShowProgressbar() {
    }

    override fun onHideProgressbar() {
    }

    override fun showNow(manager: FragmentManager?, tag: String?) {
        if (!this.isAdded)
            super.showNow(manager, tag)
    }

    override fun show(manager: FragmentManager?, tag: String?) {
        if (!this.isAdded)
            super.show(manager, tag)
    }

    override fun show(transaction: FragmentTransaction?, tag: String?): Int =
        if (this.isAdded) super.show(transaction, tag)
        else -1

    companion object {
        private const val TAG: String = "BaseFragment"
    }
}
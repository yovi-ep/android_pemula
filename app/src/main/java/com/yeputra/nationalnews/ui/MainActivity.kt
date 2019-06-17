
package com.yeputra.nationalnews.ui
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.yeputra.nationalnews.R
import com.yeputra.nationalnews.adapter.ListAdapter
import com.yeputra.nationalnews.repository.getDataSource
import hub.gotroy.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var listAdapter: ListAdapter

    private lateinit var detailDialog: DetailPresidenFm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        detailDialog = DetailPresidenFm()

        listAdapter = ListAdapter {
            val bundle = Bundle()
            bundle.putParcelable("data", it)
            detailDialog.arguments = bundle
            detailDialog.show(supportFragmentManager, "detail")
        }

        val layout = LinearLayoutManager(this)
        rvitem.layoutManager = layout
        rvitem.setHasFixedSize(false)
        rvitem.overScrollMode = View.OVER_SCROLL_NEVER
        rvitem.adapter = listAdapter

        listAdapter.addItem(getDataSource())
    }
}

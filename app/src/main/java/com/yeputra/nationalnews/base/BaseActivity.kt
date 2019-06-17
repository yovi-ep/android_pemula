package hub.gotroy.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yeputra.nationalnews.base.IBasePresenter
import com.yeputra.nationalnews.base.IBaseView


/**
 * Created by yovi.putra
 *    on 09/Mar/2019 10:56
 * Company SIEMO - PT. Multipolar Technology, Tbk
 */
abstract class BaseActivity
    : AppCompatActivity(), IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    override fun getContextView(): Context = this

    override fun onShowProgressbar() {}

    override fun onHideProgressbar() {}

    override fun onPresenterSuccess(data: Any?) {
    }

    override fun onPresenterFailed(message: String?) {
    }

    companion object {
        private val TAG: String? = BaseActivity::class.java.simpleName
    }
}
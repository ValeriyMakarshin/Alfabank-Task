package com.hodzi.alfabanktask.utils.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

abstract class BaseFragment<in V : BaseContract.View, P : BaseContract.Presenter<V>> :
    Fragment(), BaseContract.View {

    @Inject lateinit var presenter: P

    protected abstract fun getActivityInfo(): ActivityInfo

    protected abstract fun injection(): () -> Unit

    protected open fun viewInit() {

    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater?.inflate(getActivityInfo().layoutId, container, false)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injection().invoke()

        viewInit()

        presenter.attach(this as V, arguments)
    }
}

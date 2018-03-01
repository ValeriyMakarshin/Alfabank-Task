package com.hodzi.alfabanktask.utils.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<in V : BaseContract.View, P : BaseContract.Presenter<V>> :
    AppCompatActivity(), BaseContract.View {

    @Inject lateinit var presenter: P

    protected abstract fun getActivityInfo(): ActivityInfo

    protected abstract fun injection(): () -> Unit

    protected open fun viewInit() {

    }

    @CallSuper
    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityInfo().layoutId)

        injection().invoke()

        getActivityInfo().toolbar?.let { setSupportActionBar(it) }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        viewInit()
        presenter.attach(this as V, intent.extras)
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    override fun setTitle(title: String) {
        getActivityInfo().toolbar?.title = title
    }
}

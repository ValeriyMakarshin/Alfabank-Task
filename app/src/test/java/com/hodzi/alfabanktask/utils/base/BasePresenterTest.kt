package com.hodzi.alfabanktask.utils.base

import android.os.Bundle
import com.nhaarman.mockito_kotlin.*
import junit.framework.Assert
import org.junit.Test

class BasePresenterTest {
    val spyBasePresenter = spy(BasePresenter<BaseContract.View>())

    @Test fun detachTest() {
        spyBasePresenter.detach()

        verify(spyBasePresenter).unsubscribeSubscription()
    }

    @Test fun parseArgumentsTest() {
        val expectedBundle: Bundle = Bundle()

        spyBasePresenter.parseArguments(expectedBundle)

        Assert.assertEquals(spyBasePresenter.bundle, expectedBundle)
    }

    @Test fun attachTest() {
        val expectedView: BaseContract.View = mock()
        val expectedBundle = Bundle()
        doNothing()
            .`when`(spyBasePresenter).parseArguments(any())

        spyBasePresenter.attach(expectedView, expectedBundle)

        verify(spyBasePresenter).loadData()
        verify(spyBasePresenter).parseArguments(expectedBundle)
    }

}
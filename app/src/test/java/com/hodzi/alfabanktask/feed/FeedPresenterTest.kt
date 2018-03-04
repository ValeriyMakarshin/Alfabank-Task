package com.hodzi.alfabanktask.feed

import com.hodzi.alfabanktask.RxHook
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.interactor.Interactor
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable
import org.junit.Assert
import org.junit.Rule
import org.junit.Test


class FeedPresenterTest {
    @Rule @JvmField
    val schedulers = RxHook()

    val mockInteractor: Interactor = mock()
    val feedPresenter: FeedPresenter = FeedPresenter(mockInteractor)

    @Test fun loadDataTest() {
        val expectedFeedItems = ArrayList<FeedItemEntity>()
        doReturn(Flowable.just(expectedFeedItems))
            .`when`(mockInteractor).getDbList()
        val mockFeedView: FeedContract.View = mock()
        feedPresenter.view = mockFeedView

        feedPresenter.loadData()

        verify(mockFeedView).showList(expectedFeedItems)
        Assert.assertEquals(expectedFeedItems, feedPresenter.list)
    }

    @Test fun refreshTest() {
        val mockFeedView: FeedContract.View = mock()
        feedPresenter.view = mockFeedView

        feedPresenter.refresh()

        verify(mockInteractor).refresh(any(), any())
    }

    @Test fun unsubscribeSubscriptionTest() {
        val mockDisposable: Disposable = mock {
            on { isDisposed }.doReturn(false)
        }
        feedPresenter.disposable = mockDisposable

        feedPresenter.unsubscribeSubscription()

        verify(mockDisposable).dispose()
        Assert.assertNull(feedPresenter.disposable)
    }

    @Test fun unsubscribeSubscriptionTestDisposed() {
        val mockDisposable: Disposable = mock {
            on { isDisposed }.doReturn(true)
        }
        feedPresenter.disposable = mockDisposable

        feedPresenter.unsubscribeSubscription()

        verify(mockDisposable, never()).dispose()
        Assert.assertEquals(feedPresenter.disposable, mockDisposable)
    }
}
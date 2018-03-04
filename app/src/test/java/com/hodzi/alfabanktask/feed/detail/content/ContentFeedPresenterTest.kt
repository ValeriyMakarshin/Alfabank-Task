package com.hodzi.alfabanktask.feed.detail.content

import android.os.Bundle
import com.hodzi.alfabanktask.RxHook
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.nhaarman.mockito_kotlin.*
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ContentFeedPresenterTest {
    @Rule @JvmField
    val schedulers = RxHook()

    val spyContentFeedPresenter: ContentFeedPresenter = spy(ContentFeedPresenter())

    @Test fun parseArgumentsTest() {
        val expectedFeedItems = FeedItemEntity()
        val mockBundle: Bundle = mock {
            on { getParcelable<FeedItemEntity>(ContentFeedFragment.EXTRA_FEED_ITEM) }
                .doReturn(expectedFeedItems)
        }

        spyContentFeedPresenter.parseArguments(mockBundle)

        Assert.assertEquals(expectedFeedItems, spyContentFeedPresenter.feedItemEntity)
    }

    @Test fun attachTest() {
        val expectedTitle = "testTitle"
        val expectedFeedItem = FeedItemEntity(title = expectedTitle)
        spyContentFeedPresenter.feedItemEntity = expectedFeedItem
        doNothing()
            .`when`(spyContentFeedPresenter).parseArguments(any())
        val mockContentFeedView: ContentFeedContract.View = mock()
        val mockBundle: Bundle = mock()

        spyContentFeedPresenter.attach(mockContentFeedView, mockBundle)

        verify(mockContentFeedView).setTitle(expectedTitle)
    }

    @Test fun loadDataTest() {
        val expectedDescription = "testDescription"
        val expectedFeedItem = FeedItemEntity(description = expectedDescription)
        spyContentFeedPresenter.feedItemEntity = expectedFeedItem
        val mockContentFeedView: ContentFeedContract.View = mock()
        spyContentFeedPresenter.view = mockContentFeedView

        spyContentFeedPresenter.loadData()

        verify(mockContentFeedView).setData(expectedDescription)
    }

}
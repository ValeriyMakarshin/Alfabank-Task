package com.hodzi.alfabanktask.feed.detail

import android.os.Bundle
import android.os.Parcelable
import com.hodzi.alfabanktask.RxHook
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.interactor.Interactor
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class DetailFeedPresenterTest {
    @Rule @JvmField
    val schedulers = RxHook()

    val mockInteractor: Interactor = mock()
    val detailFeedPresenter: DetailFeedPresenter = DetailFeedPresenter(mockInteractor)

    @Test fun parseArgumentsTest() {
        val expectedPosition = 3
        val expectedFeedItems = emptyArray<Parcelable>()
        val mockBundle: Bundle = mock {
            on { getInt(DetailFeedActivity.EXTRA_POSITION) }.doReturn(expectedPosition)
            on { getParcelableArray(DetailFeedActivity.EXTRA_FEED_ITEM_LIST) }.doReturn(expectedFeedItems)
        }

        detailFeedPresenter.parseArguments(mockBundle)

        Assert.assertEquals(detailFeedPresenter.position, expectedPosition)
        Assert.assertArrayEquals(detailFeedPresenter.array, expectedFeedItems)
    }

    @Test fun switchUsedBookmarkTest() {
        val position = 0
        val expectedBookmark = true
        val expectedTitle = "title"
        val expectedFeedItem = FeedItemEntity(title = expectedTitle, bookmark = expectedBookmark)
        val expectedFeedItems: Array<FeedItemEntity> = arrayOf(expectedFeedItem)
        detailFeedPresenter.array = expectedFeedItems

        val answer = detailFeedPresenter.switchUsedBookmark(position)

        verify(mockInteractor).updateBookmarkFeedItem(expectedTitle, !expectedBookmark)
        Assert.assertEquals(expectedFeedItem.bookmark, !expectedBookmark)
        Assert.assertEquals(answer, !expectedBookmark)
    }
}
package com.hodzi.alfabanktask.feed.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.adapter.DetailFeedPagerAdapter
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.HtmlUtil
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail_feed.*
import kotlinx.android.synthetic.main.view_toolbar.*


class DetailFeedActivity : BaseActivity<DetailFeedContract.View, DetailFeedContract.Presenter>(),
    DetailFeedContract.View {
    companion object {
        const val EXTRA_POSITION = "extraPosition"
        const val EXTRA_FEED_ITEM_LIST = "extraFeedItemList"

        fun intent(context: Context, position: Int,
                   feedItemEntities: List<FeedItemEntity>): Intent {
            val bundle = Bundle()
            bundle.putInt(EXTRA_POSITION, position)
            bundle.putParcelableArray(EXTRA_FEED_ITEM_LIST, feedItemEntities.toTypedArray())
            return Intent(context, DetailFeedActivity::class.java).putExtras(bundle)
        }
    }

    override fun getActivityInfo(): ActivityInfo =
        ActivityInfo(R.layout.activity_detail_feed, toolbar)

    override fun injection(): () -> Unit = { AppInjector.inject(this) }


    override fun focusPosition(position: Int) {
        uiFeedItemsVp.currentItem = position
    }

    override fun showList(feedItemEntities: Array<FeedItemEntity>) {
        uiFeedItemsVp.adapter = DetailFeedPagerAdapter(supportFragmentManager, feedItemEntities)
    }

    override fun viewInit() {
        super.viewInit()
        uiFeedItemsVp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float,
                                        positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                presenter.array[position].title?.let {
                    setTitle(HtmlUtil.fromHtmlFormat(it).toString())
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_detail_feed, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        Log.i("132", "111")
        menu?.findItem(R.id.action_bookmark)?.icon =
            ContextCompat.getDrawable(this, getIcon(presenter.usedBookmark(
                uiFeedItemsVp.currentItem
            )))
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_bookmark -> {
                val newBoolean = presenter.switchUsedBookmark(uiFeedItemsVp.currentItem)
                item.icon = ContextCompat.getDrawable(this, getIcon(newBoolean))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @DrawableRes private fun getIcon(usedBookmark: Boolean): Int {
        return if (usedBookmark) {
            R.drawable.ic_bookmark_24dp
        } else {
            R.drawable.ic_bookmark_border_24dp
        }

    }

}

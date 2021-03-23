package com.gerenvip.ui.samples

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tablayout2.TabLayout
import kotlinx.android.synthetic.main.activity_sample_tablayout.*

/**
 * @author wangwei on 2019-10-06.
 * wangwei11@kuaishou.com
 */
class SampleTabLayout : AppCompatActivity() {

    private var mAdapter: TestAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_tablayout)

        mAdapter = TestAdapter(supportFragmentManager)
        view_pager.adapter = mAdapter
        view_pager.pageMargin = 36
        configTab1()
        configTab2()
        configTab3()
        configTab4()
        configTab5()
        configTab6()
        configTab7()
    }

    /**
     * 代码配置 TabItem 的 icon， xml配置 TabItem的 text ，手动关联 viewpager 和 tablayout
     */
    private fun configTab1() {
        val tabCount = tab_layout.getTabCount()
        for (i in 0 until tabCount) {
            when (i) {
                0 -> tab_layout.getTabAt(i)!!.setIcon(R.mipmap.ic_call_black_24dp)
                1 -> tab_layout.getTabAt(i)!!.setIcon(R.mipmap.ic_chat_black_24dp)
                2 -> tab_layout.getTabAt(i)!!.setIcon(R.mipmap.ic_perm_identity_black_24dp)
                3 -> tab_layout.getTabAt(i)!!.setIcon(R.mipmap.ic_settings_black_24dp)
            }
        }
        view_pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                if (position < 4) {
                    tab_layout.setScrollPosition(position, 0f, true)
                }
            }
        })
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                view_pager.setCurrentItem(position, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    /**
     * xml 配置 tab item 的 text 和icon， 手动关联viewpager 和 tabLayout
     */
    private fun configTab2() {
        view_pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                if (position < 4) {
                    tab_layout_2.setScrollPosition(position, 0f, true)
                }
            }
        })
        tab_layout_2.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                view_pager.setCurrentItem(position, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    /**
     * 自动关联 viewpager和 tablayout
     */
    private fun configTab3() {
        tab_layout_3.setupWithViewPager(view_pager)
        tab_layout_3.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                Toast.makeText(this@SampleTabLayout, "select pos=$position", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        val tab = tab_layout_3.getTabAt(1)
        tab?.orCreateBadge
        tab?.badge?.backgroundColor = Color.RED
        tab?.badge?.number = 1
        tab?.badge?.badgeTextColor = Color.WHITE
    }

    private fun configTab4() {
        //        tab_layout_4.tabMode = TabLayout.MODE_AUTO
        tab_layout_4.setupWithViewPager(view_pager)
        val tabCount = tab_layout_4.tabCount
        for (i in 0 until tabCount) {
            val tab = tab_layout_4.getTabAt(i)
            //            tab?.setCustomView(R.layout.view_custom)
        }
        tab_layout_4.isTabIndicatorSticky = true
        //        tab_layout_4.setIndicatorInterpolator(AccelerateInterpolator(), DecelerateInterpolator(1.25f))
    }

    private fun configTab5() {
        tab_layout_5.setupWithViewPager(view_pager)
    }

    private fun configTab6() {
        tab_layout_6.setupWithViewPager(view_pager)
        //        tab_layout_6.setSelectedTabIndicator(R.drawable.dot_indicator_white_rect)
        //        tab_layout_6.isRetainTabIndicatorSize = true
    }

    private fun configTab7() {
        tab_layout_7.setupWithViewPager(view_pager)
    }

    fun update() {
        var currentItem = view_pager.currentItem
        val count = view_pager.adapter!!.count
        currentItem = (currentItem + 1) % count
        //        view_pager.setCurrentItem(currentItem, true)
        val tab = tab_layout_3.getTabAt(currentItem)
        tab_layout_3.selectTab(tab, true, false)
    }
}

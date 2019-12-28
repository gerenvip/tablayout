package com.gerenvip.ui.samples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tablayout2.VerticalTabLayout
import com.google.android.material.tablayout2.VerticalTabLayoutMediator
import kotlinx.android.synthetic.main.activity_sample_vertical_tablayout.*

/**
 * @author wangwei on 2019-10-06.
 * wangwei11@kuaishou.com
 */
class SampleVerticalTabLayout : AppCompatActivity() {

    private var mAdapter: VerticalTestAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_vertical_tablayout)

        mAdapter = VerticalTestAdapter(this)
        view_pager.adapter = mAdapter
        configTab()
//        configTab2()
    }

    /**
     * xml 配置 tab item 的 text 和icon， 手动关联viewpager 和 tabLayout
     */
    private fun configTab() {
        VerticalTabLayoutMediator(tab_layout, view_pager) { tab, position ->
            tab.text = "Page-$position"
            tab.orCreateBadge
        }.attach()
    }

    private fun configTab2() {
        tab_layout.setSelectedTabIndicatorWidth(0)
        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position < 4) {
                    tab_layout.setScrollPosition(position, 0f, true)
                }
            }
        })

        tab_layout.addOnTabSelectedListener(object : VerticalTabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: VerticalTabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: VerticalTabLayout.Tab?) {
            }

            override fun onTabSelected(tab: VerticalTabLayout.Tab) {
                val position = tab.position
                view_pager.setCurrentItem(position, true)
            }

        })
    }
}
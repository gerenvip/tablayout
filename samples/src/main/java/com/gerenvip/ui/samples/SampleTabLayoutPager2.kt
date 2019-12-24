package com.gerenvip.ui.samples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tablayout2.TabLayout
import com.google.android.material.tablayout2.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_sample_tablayout_pager2.*

/**
 * @author wangwei on 2019-10-06.
 * wangwei11@kuaishou.com
 */
class SampleTabLayoutPager2 : AppCompatActivity() {

    private var mAdapter: VerticalTestAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_tablayout_pager2)

        mAdapter = VerticalTestAdapter(this)
        view_pager.adapter = mAdapter
//        configTab()
        configTab2()
    }

    /**
     * xml 配置 tab item 的 text 和icon， 手动关联viewpager 和 tabLayout
     */
    private fun configTab() {
        TabLayoutMediator(tab_layout, view_pager) { tab, position ->
            tab.text = "Page-$position"
        }.attach()
    }

    private fun configTab2() {
        tab_layout.setSelectedTabIndicatorHeight(0)
        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position < 4) {
                    tab_layout.setScrollPosition(position, 0f, true)
                }
            }
        })

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                view_pager.setCurrentItem(position, true)
            }

        })
    }
}
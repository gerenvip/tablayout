package com.gerenvip.ui.samples

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @author gerenvip.Wayne on 2019-12-23.
 */
class VerticalTestAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(
    fragmentActivity
) {
    private val fragments: MutableList<TestFragment> = mutableListOf()
    private val COUNT = 6

    init {
        fragments.clear()
        for (i in 0 until COUNT) {
            fragments.add(TestFragment.instance("Page: " + (i + 1)))
        }
    }

    override fun getItemCount(): Int = COUNT

    override fun createFragment(position: Int): Fragment {
        return fragments.get(position)
    }
}
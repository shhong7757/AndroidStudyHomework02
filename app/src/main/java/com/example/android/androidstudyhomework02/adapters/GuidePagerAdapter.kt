package com.example.android.androidstudyhomework02.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.androidstudyhomework02.Guide01Fragment
import com.example.android.androidstudyhomework02.Guide02Fragment
import com.example.android.androidstudyhomework02.Guide03Fragment

class GuidePagerAdapter(fm : FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment = Guide01Fragment()
        when(position) {
            0 -> fragment = Guide01Fragment()
            1 -> fragment = Guide02Fragment()
            2 -> fragment = Guide03Fragment()
        }

        return fragment
    }
}
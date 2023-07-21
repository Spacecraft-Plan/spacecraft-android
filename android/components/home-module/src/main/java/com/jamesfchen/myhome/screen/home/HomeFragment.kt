package com.jamesfchen.myhome.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.jamesfchen.myhome.databinding.FragmentHomeBinding

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks jamesf
 * @since: 2017/7/4
 */
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pager.adapter = HomeAdapter(this)
        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, binding.pager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
    }

    inner class HomeAdapter(f: Fragment) : FragmentStateAdapter(f) {
        val list = listOf(
            DoubleListFragment::class.java,
            VideoListFragment::class.java,
        )

        override fun getItemCount() = list.size

        override fun createFragment(position: Int): Fragment{
            val newInstance = list[position].newInstance()
            return newInstance
        }

    }
}
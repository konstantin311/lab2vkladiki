package com.example.lab2vkladiki

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentsList = listOf(FirstFragment(), SecondFragment(), ThirdFragment())
    private val tabTitles = listOf("Изображение+надпись", "ListView", "TableLayout")

    override fun getItemCount(): Int {
        return fragmentsList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]
    }

    fun getTabTitle(position: Int): String {
        return tabTitles[position]
    }
}
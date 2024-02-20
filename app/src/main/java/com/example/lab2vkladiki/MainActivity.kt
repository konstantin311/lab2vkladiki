package com.example.lab2vkladiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentAdapter: FragmentPageAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabs: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentAdapter = FragmentPageAdapter(supportFragmentManager,lifecycle)
        setContentView(R.layout.activity_main)
        tabs = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = fragmentAdapter

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = fragmentAdapter.getTabTitle(position) // Устанавливаем заголовки вкладок
        }.attach()


        //tabs.setupWithViewPager(viewPager)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabs.getTabAt(position)?.select()
            }
        })

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewPager.currentItem = it.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })



    }
}
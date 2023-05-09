package com.example.ecommercer_app.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import com.example.ecommercer_app.R
import com.example.ecommercer_app.adapters.HomeViewPagerAdapter
import com.example.ecommercer_app.databinding.FragmentHomeBinding
import com.example.ecommercer_app.fragments.categories.*
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            ChairFragment(),
            CupboardFragment(),
            TableFragment(),
            AccessoryFragment(),
            FurnitureFragment(),
        )

        binding.viewPagerHome.isUserInputEnabled = false

        val viewPager2Adapter = HomeViewPagerAdapter(categoriesFragments,childFragmentManager,lifecycle)
        binding.viewPagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout,binding.viewPagerHome){
            tab, position -> when(position){
                0 -> tab.text = "Main"
                1 -> tab.text = "Chair"
                2 -> tab.text = "Cupboard"
                3 -> tab.text = "Table"
                4 -> tab.text = "Accessory"
                5 -> tab.text = "Furniture"
            }
        }.attach()
    }



}
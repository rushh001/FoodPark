package com.example.foodpark;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodpark.databinding.FragmentHomeBinding;
import com.example.foodpark.databinding.FragmentTrendingBinding;
import com.google.android.material.tabs.TabLayout;


public class TrendingFragment extends Fragment {

    FragmentTrendingBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTrendingBinding.inflate(inflater, container, false);
         return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getFragmentManager().beginTransaction().detach(TrendingFragment.this).attach(TrendingFragment.this).commit();
        tabLayout = binding.tabLayout;
        viewPager2 = binding.viewPager;
        view_pager_adapter_trend viewPagerAdapterTrend = new view_pager_adapter_trend(getActivity());
        viewPager2.setAdapter(viewPagerAdapterTrend);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager2.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //viewPager2.refreshDrawableState(tab.getPosition(), true);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition(), true);
            }
        });

        // React to page changes in ViewPager2
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.setScrollPosition(position, 0, true);
               //

            }
        });

    }

    }

package com.example.foodpark;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.foodpark.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        getFragmentManager().beginTransaction().detach(HomeFragment.this).attach(HomeFragment.this).commit();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getFragmentManager().beginTransaction().detach(HomeFragment.this).attach(HomeFragment.this).commit();

        // Initialize tabLayout and viewPager2
        tabLayout = binding.tabLayout;
        viewPager2 = binding.viewPager;
        view_pager_adapter viewPagerAdapter = new view_pager_adapter(getActivity());
        viewPager2.setAdapter(viewPagerAdapter);

        // Link TabLayout with ViewPager2
//        new TabLayoutMediator(tabLayout, viewPager2,
//                (tab, position) -> tab.setText("Tab " + (position + 1))
//        ).attach();

        // React to tab selection changes


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager2.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition(), true);
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
                getFragmentManager().beginTransaction().detach(HomeFragment.this).attach(HomeFragment.this).commit();


            }
        });
        viewPager2.setCurrentItem(1);
    }
}

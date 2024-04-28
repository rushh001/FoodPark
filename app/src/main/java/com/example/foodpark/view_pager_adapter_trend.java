package com.example.foodpark;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class view_pager_adapter_trend extends FragmentStateAdapter {
    public view_pager_adapter_trend(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position)
        {

            case 0:
                return new AllTrendFragment();
            case 1:
                return new SouthTrendFragment();
            case 2:
                return new NorthTrendFragment();
            default:
                return new AllTrendFragment();


        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

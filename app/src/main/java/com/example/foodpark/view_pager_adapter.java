package com.example.foodpark;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class view_pager_adapter extends FragmentStateAdapter {
    public view_pager_adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
     switch(position)
     {
            case 0:

             return new HistoryFragment();
            case 1:
             return new MenuFragment();
            case 2:
             return new BasketFragment();
            case 3:
             return new FavouriteFragment();
             default:
             return new MenuFragment();


     }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

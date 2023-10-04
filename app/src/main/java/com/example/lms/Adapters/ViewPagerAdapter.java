package com.example.lms.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lms.Fragments.TabDashBoardFragment;
import com.example.lms.Fragments.TabNewsFeedFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new TabDashBoardFragment();
            case 1: return new TabNewsFeedFragment();
            default: return new TabDashBoardFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

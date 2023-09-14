package com.example.lms.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lms.Fragments.TabOneFragment;
import com.example.lms.Fragments.TabThreeFragment;
import com.example.lms.Fragments.TabTwoFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new TabOneFragment();
            case 1: return new TabTwoFragment();
            case 2: return new TabThreeFragment();
            default: return new TabOneFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

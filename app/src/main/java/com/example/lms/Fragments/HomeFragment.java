package com.example.lms.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.lms.Adapters.ViewPagerAdapter;
import com.example.lms.DashBoardActivity;
import com.example.lms.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        //initialize
        tabLayout=view.findViewById(R.id.tabLayout);
        viewPager2=view.findViewById(R.id.viewPager);
        viewPagerAdapter=new ViewPagerAdapter(requireActivity());

        viewPager2.setAdapter(viewPagerAdapter);

        bottomNavigationView=view.findViewById(R.id.bottomNav);
        frameLayout=view.findViewById(R.id.home_fragment_frame_layout);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                    case 1:
                    case 2:
                        tabLayout.getTabAt(position).select();


                }
                super.onPageSelected(position);
            }
        });

bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        viewPager2.setVisibility(View.GONE);
        frameLayout.setVisibility(View.VISIBLE);
       switch (item.getItemId()){
           case R.id.learningNavItem:
               requireFragmentManager()
                       .beginTransaction()
                       .replace(R.id.home_fragment_frame_layout,new LearningFragment())
                       .commit();
               return true;
           case R.id.assignmentNavItem:
               requireFragmentManager()
                       .beginTransaction()
                       .replace(R.id.home_fragment_frame_layout,new AssignmentsFragment())
                       .commit();
               return true;
           case R.id.profileNavItem:
               requireFragmentManager()
                       .beginTransaction()
                       .replace(R.id.home_fragment_frame_layout,new ProfileFragment())
                       .commit();
               return true;

       }

        return true;
    }
});




        return view;
    }

}


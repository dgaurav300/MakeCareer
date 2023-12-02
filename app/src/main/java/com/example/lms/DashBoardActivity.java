package com.example.lms;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.lms.Fragments.HomeFragment;
import com.example.lms.Fragments.ProfileFragment;
import com.google.android.material.navigation.NavigationView;


public class DashBoardActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private FrameLayout fragmentContainer;

    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


        

        // Initialize Views
        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar);

        fragmentContainer = findViewById(R.id.fragment_container);

        navigationView = findViewById(R.id.navigationView);
        View headerView = navigationView.getHeaderView(0);


        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               replaceFragment(new ProfileFragment());
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                // Handle the click event for the navigation header
                // For example, you might want to open a new activity or perform some action
                Toast.makeText(getApplicationContext(), "Header Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        // Set up the Toolbar
        setSupportActionBar(toolbar);
        replaceFragment(new HomeFragment());


        // Set up the ActionBarDrawerToggle for the Drawer
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Handle Bottom Navigation View item clicks
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                return false;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Open/close the Drawer when the hamburger icon is clicked
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Helper method to replace fragments in the fragment container
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


}
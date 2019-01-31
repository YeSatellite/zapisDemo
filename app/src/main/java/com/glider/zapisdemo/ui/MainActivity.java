package com.glider.zapisdemo.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.glider.zapisdemo.R;
import com.glider.zapisdemo.ui.profile.ProfileFragment;
import com.glider.zapisdemo.ui.salon.SalonNavFragment;
import com.glider.zapisdemo.ui.search.SearchFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment;
            switch (item.getItemId()) {
                case R.id.m_salon:
                    selectedFragment = new SalonNavFragment();
                    break;
                case R.id.m_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.m_profile:
                    selectedFragment = new ProfileFragment();
                    break;
                default:
                    selectedFragment = new SalonNavFragment();
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, selectedFragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager();

        BottomNavigationViewEx navigation = findViewById(R.id.navigation);
        navigation.enableAnimation(false);
        navigation.enableShiftingMode(false);
        navigation.enableItemShiftingMode(false);
        navigation.setTextVisibility(false);
        navigation.setOnNavigationItemSelectedListener(navigationListener);

        navigation.setCurrentItem(0);
    }


}

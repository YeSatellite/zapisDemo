package com.glider.zapisdemo.ui.salon;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glider.zapisdemo.R;
import com.glider.zapisdemo.ui.salon.salonList.SalonPopularListFragment;
import com.glider.zapisdemo.ui.salon.salonList.SalonRecentlyAddedListFragment;
import com.glider.zapisdemo.ui.salon.salonList.SalonRecommendedListFragment;

import java.util.Objects;


public class SalonNavFragment extends Fragment {


    public SalonNavFragment() {}


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_salon_nav, container, false);
        Toolbar toolbar = v.findViewById(R.id.toolbar);
        ViewPager pager = v.findViewById(R.id.pager);
        TabLayout tabLayout = v.findViewById(R.id.tab_layout);

        toolbar.setTitle(getString(R.string.app_name));
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);

        pager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            private String[] tabs = new String[]{
                    getString(R.string.popular),
                    getString(R.string.recommended),
                    getString(R.string.recently_added)};

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }

            @Override
            public Fragment getItem(int i) {
                Fragment selectedFragment;
                switch (i){
                    case 0:
                        selectedFragment = new SalonPopularListFragment();
                        break;
                    case 1:
                        selectedFragment = new SalonRecommendedListFragment();
                        break;
                    case 2:
                        selectedFragment = new SalonRecentlyAddedListFragment();
                        break;
                    default:
                        selectedFragment = new SalonPopularListFragment();
                }

                return selectedFragment;
            }

            @Override
            public int getCount() {
                return tabs.length;
            }
        });
        tabLayout.setupWithViewPager(pager);

        return v;
    }

}

package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.codepath.testingdemo.R;
import com.codepath.testingdemo.fragments.EmptyFragment;

public class ViewPagerActivity extends GameLevelActivity implements EmptyFragment.OnAnswerClickedListener {


    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new PagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    @Override
    public void onAnswerClicked() {
        launchLevelPassedActivity();
    }


    public class PagerAdapter extends FragmentPagerAdapter {
        private final int NUM_ITEMS = 3;

        public PagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return EmptyFragment.newInstance(
                            ViewPagerActivity.this.getResources().getColor(android.R.color.holo_red_light),
                            false);
                case 1:
                    return EmptyFragment.newInstance(
                            ViewPagerActivity.this.getResources().getColor(android.R.color.holo_orange_dark),
                            false);
                case 2:
                    return EmptyFragment.newInstance(
                            ViewPagerActivity.this.getResources().getColor(android.R.color.holo_blue_bright),
                            true);
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }
}

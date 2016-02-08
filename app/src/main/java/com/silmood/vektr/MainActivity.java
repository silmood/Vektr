package com.silmood.vektr;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final Class[] CLASSES_FRAGMENTS = {SimpleVectorFragment.class, AnimatedVectorFragment.class, ShapeTransformationFragment.class};

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mAdapter = new PagerAdapter(getSupportFragmentManager(), getFragments());

        setupToolbar();
        setupTabs(mTabLayout, mViewPager, mAdapter);
    }

    private List<PagerFragment> getFragments() {
        List<PagerFragment> fragments = new ArrayList<>();

        for (Class fragmentClass : CLASSES_FRAGMENTS) {
            try {
                fragments.add((PagerFragment) fragmentClass.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return fragments;
    }

    private void setupTabs(TabLayout tabLayout, ViewPager viewPager, FragmentPagerAdapter adapter) {
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public class PagerAdapter extends FragmentPagerAdapter{

        private List<PagerFragment> mFragments;

        public PagerAdapter(FragmentManager fm, List<PagerFragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getString(mFragments.get(position).getTitleRes());
        }
    }

}

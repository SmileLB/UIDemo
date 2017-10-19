package com.example.administrator.wxeffectdemo.activitys;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.administrator.wxeffectdemo.R;
import com.example.administrator.wxeffectdemo.fragments.HolderFragment;
import com.example.administrator.wxeffectdemo.fragments.HomeFragment;
import com.example.mylibrary.byeBurger.BottomNavigationViewHelper;
import com.example.mylibrary.byeBurger.ByeBurgerBehavior;

import java.util.ArrayList;
import java.util.List;

public class Activity7 extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ViewPager mViewPager;
    private List<Fragment> fragmentList;
    private BottomNavigationView mNavigationView;
    private FloatingActionButton mFloatButton;
    private ByeBurgerBehavior mBehavior;
    private Toolbar mToolbar;
    private MenuItem prevMenuItem;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        initData();
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("欢迎来到王者荣耀！！！");
//        setSupportActionBar(mToolbar);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mNavigationView = (BottomNavigationView) findViewById(R.id.bye_burger);
        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationViewHelper.disableShiftMode(mNavigationView);

        mFloatButton = (FloatingActionButton) findViewById(R.id.floatButton);

        mBehavior = ByeBurgerBehavior.from(mFloatButton);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override public int getCount() {
                return fragmentList.size();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mNavigationView.getMenu().getItem(0).setChecked(false);
                }
                mNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        mNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        if(item.getTitle().equals("home")){
                            mBehavior.show();
                            mViewPager.setCurrentItem(0);
                        }else if(item.getTitle().equals("search")){
                            ByeBurgerBehavior.from(mToolbar).hide();
                            mBehavior.hide();
                            mViewPager.setCurrentItem(1);
                        }else if(item.getTitle().equals("me")){

                            mBehavior.hide();
                            mViewPager.setCurrentItem(2);
                        }else if(item.getTitle().equals("setting")){
                            mBehavior.hide();
                            mViewPager.setCurrentItem(3);
                        }
                        return false;
                    }
                });

    }

    private void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.newInstance());

        fragmentList.add(HolderFragment.newInstance("查询"));

        fragmentList.add(HolderFragment.newInstance("我的"));

        fragmentList.add(HolderFragment.newInstance("设置"));
    }
}

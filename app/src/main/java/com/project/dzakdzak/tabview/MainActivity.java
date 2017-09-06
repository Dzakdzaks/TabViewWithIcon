package com.project.dzakdzak.tabview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //dekalarasi
    TabLayout tabLayout;
    ViewPager viewPager;
    private int [] gambaricon = {
        R.drawable.restaurant,R.drawable.restaurant
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.vPager);
        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager();
        setUpTabICon();
    }
    public void setUpTabICon(){
        tabLayout.getTabAt(0).setIcon(gambaricon[0]);
        tabLayout.getTabAt(1).setIcon(gambaricon[1]);
    }

    private void setUpViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new Fragment1(), "Kuliner");
        adapter.addFragment(new Fragment3(),"Surat");
        adapter.addFragment(new Fragment2(), "Kuliner");
//        adapter.addFragment(new Fragment3(), "Kuliner");
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> nameList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return nameList.get(position);

        }

      public void addFragment (Fragment fragment, String title){
          fragmentList.add(fragment);
          nameList.add(title);
      }

    }





}

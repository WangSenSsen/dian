package fqd.com.fanqingdian20181220;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Frag1 extends Fragment {

    private TabLayout tablayout;
    private ViewPager pager;
    List<Fragment> fragmentList=new ArrayList<>();
    List<String> titleList=new ArrayList<>();
    private Frag01 frag01;
    private Frag02 frag02;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag1,container,false);
        tablayout = view.findViewById(R.id.tablayout);
        pager = view.findViewById(R.id.pager);
        frag01 = new Frag01();
        frag02 = new Frag02();
        fragmentList.add(frag01);
        fragmentList.add(frag02);
        titleList.add("正在热映");
        titleList.add("即将上映");
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getChildFragmentManager());
        pager.setAdapter(myPagerAdapter);
        tablayout.setupWithViewPager(pager);
        return view;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}

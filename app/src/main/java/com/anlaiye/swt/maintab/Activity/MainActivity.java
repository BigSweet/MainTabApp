package com.anlaiye.swt.maintab.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anlaiye.swt.maintab.Fragment.TabDuanZiFragment;
import com.anlaiye.swt.maintab.Fragment.TabFenLeiFragment;
import com.anlaiye.swt.maintab.Fragment.TabFriendFragment;
import com.anlaiye.swt.maintab.Fragment.TabMainFragment;
import com.anlaiye.swt.maintab.Fragment.TabSettingFragment;
import com.anlaiye.swt.maintab.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout MainLayout, FriendLayout, FenLeiLayout, DuanZiLayout, StiingLayout;
    private ImageButton MainButton, FriendButton, FenLeiButton, DuanZiButton, SettingButton;
    private TextView MainTv,FriendTv,FenLeiTv,DuanZiTv,SettingTv;
    private ViewPager mViewPager;
    private List<Fragment> mViews = new ArrayList<>();
    private List<Integer> imglist = new ArrayList<>();
    private List<Integer> selectimglist = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        MainLayout = (LinearLayout) findViewById(R.id.id_tab_zhuye);
        FriendLayout = (LinearLayout) findViewById(R.id.id_tab_frd);
        FenLeiLayout = (LinearLayout) findViewById(R.id.id_tab_fenlei);
        DuanZiLayout = (LinearLayout) findViewById(R.id.id_tab_duanzi);
        StiingLayout = (LinearLayout) findViewById(R.id.id_tab_setting);

        MainButton = (ImageButton) findViewById(R.id.id_tab_zhuye_img);
        FriendButton = (ImageButton) findViewById(R.id.id_tab_frd_img);
        FenLeiButton = (ImageButton) findViewById(R.id.id_tab_fenlei_img);
        DuanZiButton = (ImageButton) findViewById(R.id.id_tab_duanzi_img);
        SettingButton = (ImageButton) findViewById(R.id.id_tab_setting_img);

        MainTv= (TextView) findViewById(R.id.tv_zhuye);
        FriendTv= (TextView) findViewById(R.id.tv_friend);
        FenLeiTv= (TextView) findViewById(R.id.tv_fenlei);
        DuanZiTv= (TextView) findViewById(R.id.tv_duanzi);
        SettingTv= (TextView) findViewById(R.id.tv_center);

        MainLayout.setOnClickListener(this);
        FriendLayout.setOnClickListener(this);
        FenLeiLayout.setOnClickListener(this);
        DuanZiLayout.setOnClickListener(this);
        StiingLayout.setOnClickListener(this);

        getFrament();
        getimg();
        getname();
        getSelectImg();
        mViewPager.setAdapter(new ViewPagweAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currItem = mViewPager.getCurrentItem();
                reset();
                resetColor();
                switch (currItem){
                    case 0:
                        MainButton.setImageResource(selectimglist.get(position));
                        MainTv.setTextColor(Color.parseColor("#ffdc5b"));
                        break;
                    case 1:
                        FriendButton.setImageResource(selectimglist.get(1));
                        FriendTv.setTextColor(Color.parseColor("#ffdc5b"));
                        break;
                    case 2:
                        FenLeiButton.setImageResource(selectimglist.get(2));
                        FenLeiTv.setTextColor(Color.parseColor("#ffdc5b"));
                        break;
                    case 3:
                        DuanZiButton.setImageResource(selectimglist.get(3));
                        DuanZiTv.setTextColor(Color.parseColor("#ffdc5b"));
                        break;
                    case 4:
                        SettingButton.setImageResource(selectimglist.get(4));
                        SettingTv.setTextColor(Color.parseColor("#ffdc5b"));
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void resetColor() {
        MainTv.setTextColor(Color.parseColor("#dfdfdfdf"));
        FriendTv.setTextColor(Color.parseColor("#dfdfdfdf"));
        FenLeiTv.setTextColor(Color.parseColor("#dfdfdfdf"));
        DuanZiTv.setTextColor(Color.parseColor("#dfdfdfdf"));
        SettingTv.setTextColor(Color.parseColor("#dfdfdfdf"));
    }

    private void getSelectImg() {
        selectimglist.add(R.mipmap.select_home);
        selectimglist.add(R.mipmap.friend_select);
        selectimglist.add(R.mipmap.select_category);
        selectimglist.add(R.mipmap.baike_select);
        selectimglist.add(R.mipmap.select_my);
    }

    private void getFrament() {
        mViews.add(TabMainFragment.newInstance());
        mViews.add(TabFriendFragment.newInstance());
        mViews.add(TabFenLeiFragment.newInstance());
        mViews.add(TabDuanZiFragment.newInstance());
        mViews.add(TabSettingFragment.newInstance());
    }


    public List<String> getname() {
        nameList.add("主页");
        nameList.add("朋友圈");
        nameList.add("分类");
        nameList.add("段子");
        nameList.add("个人中心");
        return nameList;
    }

    public List<Integer> getimg() {
        imglist.add(R.mipmap.home);
        imglist.add(R.mipmap.friend);
        imglist.add(R.mipmap.category);
        imglist.add(R.mipmap.baike_not_select);
        imglist.add(R.mipmap.my_icon);
        return imglist;
    }

    @Override
    public void onClick(View v) {
        reset();
        resetColor();

        switch (v.getId()) {
            case R.id.id_tab_zhuye:
                mViewPager.setCurrentItem(0);
                MainButton.setImageResource(selectimglist.get(0));
                MainTv.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case R.id.id_tab_frd:
                mViewPager.setCurrentItem(1);
                FriendButton.setImageResource(selectimglist.get(1));
                FriendTv.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case R.id.id_tab_fenlei:
                mViewPager.setCurrentItem(2);
                FenLeiButton.setImageResource(selectimglist.get(2));
                FenLeiTv.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case R.id.id_tab_duanzi:
                mViewPager.setCurrentItem(3);
                DuanZiButton.setImageResource(selectimglist.get(3));
                DuanZiTv.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case R.id.id_tab_setting:
                mViewPager.setCurrentItem(4);
                SettingButton.setImageResource(selectimglist.get(4));
                SettingTv.setTextColor(getResources().getColor(R.color.yellow));
                break;
        }
    }

    private void reset() {
        MainButton.setImageResource(imglist.get(0));
        FriendButton.setImageResource(imglist.get(1));
        FenLeiButton.setImageResource(imglist.get(2));
        DuanZiButton.setImageResource(imglist.get(3));
        SettingButton.setImageResource(imglist.get(4));
    }

    class ViewPagweAdapter extends FragmentPagerAdapter {


        public ViewPagweAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mViews.get(position);
        }

        @Override
        public int getCount() {
            return mViews.size();
        }

    }
}

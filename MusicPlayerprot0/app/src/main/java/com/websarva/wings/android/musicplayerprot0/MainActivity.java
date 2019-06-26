package com.websarva.wings.android.musicplayerprot0;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity{
    //フィールド
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter vpadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //例の2行
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //フィールドのオブジェクト化
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.pager);
        vpadapter = new ViewPageAdapter(getSupportFragmentManager());

        //各フラグメントを入れる
        vpadapter.addFragment();



//--------------------------------------------------------------------------------------------------
}


package com.websarva.wings.android.musicplayerprot0;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.pager);

        //Fragment のページ切り替えを実装
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            //getItem() ：必須　 選択したフラグメントにデータを渡して、その閲覧するFragmentを返す
            @Override
            public Fragment getItem(int position) {
                return ListViewFragment.newInstance(position + 1);
            }
            //CharSequence getPageTitle()：必要　各Fragmentのタイトルを返す
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.app_tab1);
                    case 1:
                        return getString(R.string.app_tab2);
                    case 2:
                        return getString(R.string.app_tab3);
                    case 3:
                        return getString(R.string.app_tab4);
                    case 4:
                        return "ジャンヌ";
                }
                return null;
            }
            //getCount()：必須　ViewPagerにセットするFragment数を返す
            @Override
            public int getCount() {
                return 5;
            }
        };
        viewPager.setAdapter(adapter);

    // Fragmentの遷移（ページ変更）した際、そのページにListener機能を追加する
    //引数：ViewPager.OnPageChangeListener listener
        viewPager.addOnPageChangeListener(this);

        //タブとViewPagerが連動する
        tabLayout.setupWithViewPager(viewPager);
    }
//--------------------------------------------------------------------------------------------------
    //以下3点はOnPageChangeListenerのメソッド
    //ページスクロール中に呼び出される
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
//--------------------------------------------------------------------------------------------------
    //ページが切り替わった時に呼び出される
    @Override
    public void onPageSelected(int position) {
        Log.d("MainActivity", "onPageSelected() position="+position);
    }
//--------------------------------------------------------------------------------------------------
    //スクロール状態が変化したときに呼び出される
    @Override
    public void onPageScrollStateChanged(int state) {

    }
//--------------------------------------------------------------------------------------------------
}


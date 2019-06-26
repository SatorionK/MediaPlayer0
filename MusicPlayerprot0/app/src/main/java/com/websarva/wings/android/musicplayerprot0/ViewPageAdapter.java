package com.websarva.wings.android.musicplayerprot0;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {
    //フィールド：画面切り替え用リスト、タグタイトル用リスト
    private final List<Fragment> mfragment = new ArrayList<>();
    private final List<String> title = new ArrayList<>();

    //コンストラクタ
    public ViewPageAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    //3種の神器
//--------------------------------------------------------------------------------------------------
    //タブ数の取得
    @Override
    public int getCount() {
        return title.size();
    }
//--------------------------------------------------------------------------------------------------
    //画面取得(～行目の画面取得)
    public Fragment getItem(int position){
        return mfragment.get(position);
    }
//--------------------------------------------------------------------------------------------------
    //タブ名を記載
    public CharSequence getPageTitle(int position){
        return super.getPageTitle(position);
    }
//--------------------------------------------------------------------------------------------------
    //オリジナルメソッド
    public void addFragment(Fragment fragment, String string){
        mfragment.add(fragment);
        title.add(string);
    }
//--------------------------------------------------------------------------------------------------
}

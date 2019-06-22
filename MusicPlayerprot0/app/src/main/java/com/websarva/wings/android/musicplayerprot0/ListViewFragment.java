package com.websarva.wings.android.musicplayerprot0;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListViewFragment extends Fragment {
    //コンストラクタ
    public ListViewFragment() { }
//--------------------------------------------------------------------------------------------------
    // お作法
    public static ListViewFragment newInstance(int tab) {
        Bundle bundle = new Bundle();
        bundle.putInt("tab", tab);
        ListViewFragment fragment = new ListViewFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
//--------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int tab = getArguments().getInt("tab", 0);
        //いつもならreturnでそのまま返すが今回は一旦変数宣言する。
        View view = inflater.inflate(R.layout.listview, container, false);



        return view;
    }
//--------------------------------------------------------------------------------------------------
}


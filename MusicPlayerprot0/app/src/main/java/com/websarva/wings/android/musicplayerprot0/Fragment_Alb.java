package com.websarva.wings.android.musicplayerprot0;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Alb extends Fragment {
    //フィールド
    View v;

    //コンストラクタ
    public Fragment_Alb(){

    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        v = inflater.inflate(, container, false);
        return v;
    }
}

package com.websarva.wings.android.musicplayerprot0;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Fragment_Fol extends Fragment {
    //フィールド
    View v;
    private RecyclerView fol_recyclerView;
    private List<MusicInfo> fol_musicinfo = new ArrayList<>();

//--------------------------------------------------------------------------------------------------
    //コンストラクタ
    public Fragment_Fol() {
    }

 //--------------------------------------------------------------------------------------------------
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_fol, container, false);
        //recyclervierのセット処理
        fol_recyclerView = v.findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), fol_musicinfo);
        fol_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fol_recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

//--------------------------------------------------------------------------------------------------
    @Override
    public void onCreate(Bundle savedInstanceStatic) {
        super.onCreate(savedInstanceStatic);

        //SDカードに保存した音楽ファイルを取得できる
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        //IS_MUSIC = 1を指定することで、外部ストレージの持つメディアの内、音楽のみを抜き出し
        //0の場合、音楽ファイルとみなす
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!=0";
        //お作法
        ContentResolver resolver = getActivity().getContentResolver();
        Cursor cursor = resolver.query(uri, null, selection, null, null);
        if (cursor != null) {
            //お作法：取得した結果に対するカーソルを先頭に移動させる（カーソルを次のレコードへ移動させる）
            if (cursor.moveToFirst()) {
                //カーソル内のデータ取得
                // cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.hogehoge));
                //このhogehoge箇所以外はお作法
                do {
                    String music_name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                    String art = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                    String uri2 = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    int time =  cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                    //ここでms→MM：SSに変更
                    String timech = String.format("%2d:%2d", time/60000, time/1000%60);
                    
                    //リストに加えていく
                    fol_musicinfo.add(new MusicInfo(art, music_name, uri2, timech));


                    //お作法：取得した結果に対するカーソルを次の行に移動させる
                } while (cursor.moveToNext());
            }
        }

    }
//--------------------------------------------------------------------------------------------------
}
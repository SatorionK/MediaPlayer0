package com.websarva.wings.android.musicplayerprot0;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    //フィールド
    Context mContext;
    List<MusicInfo> mData;

    //コンストラクタ
    public RecyclerViewAdapter(Context mContext, List<MusicInfo> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    //3種の神器
//--------------------------------------------------------------------------------------------------
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        //row.xmlレイアウトをインフレートする
        v = LayoutInflater.from(mContext).inflate(R.layout.row, viewGroup, false);

        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }


//--------------------------------------------------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_artN.setText(mData.get(i).getArt());
        myViewHolder.tv_musicN.setText(mData.get(i).getMusic_name());
        myViewHolder.tv_img.setImageResource(mData.get(i).getIng());
    }


//--------------------------------------------------------------------------------------------------
    @Override
    public int getItemCount() {
        return mData.size();
    }



    //holderクラスの作成
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //フィールド：アーティスト名、曲名、画像
        private TextView tv_artN;
        private TextView tv_musicN;
        private ImageView tv_img;

        //コンストラクタ
        public MyViewHolder(View itemView){
            super(itemView);

            tv_artN = itemView.findViewById(R.id.tvArtistName);
            tv_musicN = itemView.findViewById(R.id.tvSongName);
            tv_img = itemView.findViewById(R.id.img_row);
        }


    }


}

package com.websarva.wings.android.musicplayerprot0;

public class MusicInfo {
    //
    private String art;
    private String music_name;
    private int ing;

    //コンストラクタ
    public MusicInfo(){

    }
    //コンストラクタ（オーバーロード）
    public MusicInfo(String art, String music_name, int ing){
        this.art = art;
        this.music_name = music_name;
        this.ing = ing;
    }


    //getter：アーティスト名
    public String getArt() {
        return art;
    }
    //getter：曲　名
    public String getMusic_name() {
        return music_name;
    }
    //getter：画　像
    public int getIng() {
        return ing;
    }

    //setter：アーティスト名
    public void setArt(String art) {
        this.art = art;
    }
    //setter：曲　名
    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }
    //setter：画　像
    public void setIng(int ing) {
        this.ing = ing;
    }
}

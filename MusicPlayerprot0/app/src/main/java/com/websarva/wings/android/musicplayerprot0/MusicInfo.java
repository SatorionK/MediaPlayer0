package com.websarva.wings.android.musicplayerprot0;

public class MusicInfo {
    //フィールド
    private String art;
    private String music_name;
    private int ing;
    private String uri;

    //コンストラクタ
    public MusicInfo(){

    }
    //コンストラクタ（オーバーロード：画像なし）
    public MusicInfo(String art, String music_name, String uri){
        this.art = art;
        this.music_name = music_name;
        this.uri = uri;
    }

    //コンストラクタ（オーバーロード：フル）
    public MusicInfo(String art, String music_name, int ing, String uri){
        this.art = art;
        this.music_name = music_name;
        this.ing = ing;
        this.uri = uri;
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
    //getter：URI
    public String getUri() {return uri;}

    //今回は活躍せず。
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

    public void setUri(String uri) {this.uri = uri;}
}

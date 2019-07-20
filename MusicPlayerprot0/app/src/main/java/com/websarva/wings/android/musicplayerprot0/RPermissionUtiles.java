package com.websarva.wings.android.musicplayerprot0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class RPermissionUtiles {

    private RPermissionUtiles(){
    }
    //引数（変数）各メソッドに合わせる
    //staticを入れないとクラス名.メソッドとして使えない
    public static void doReqPermission(Context context, int REQUEST_CODE, Activity activity){

        //パーミッションがあるか確認
        int permissionCheck = ContextCompat.checkSelfPermission(context, READ_EXTERNAL_STORAGE);
        //値から許可を受けていない場合の処理
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            //1度拒否されたかの確認
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, READ_EXTERNAL_STORAGE)) {

                ActivityCompat.requestPermissions(activity, new String[]{READ_EXTERNAL_STORAGE}, REQUEST_CODE);
            }
            else {
                //1回許可して、設定でOFFにした際にこちらのルートに入る
                Toast.makeText(context, "パーミッションが抹消されています。", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(activity, new String[]{READ_EXTERNAL_STORAGE}, REQUEST_CODE);
            }
        }
        //許可されている場合
        else{

        }
    }
}

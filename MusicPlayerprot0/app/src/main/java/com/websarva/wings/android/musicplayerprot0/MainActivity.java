package com.websarva.wings.android.musicplayerprot0;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    //フィールド
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter vpadapter;
    final int REQUEST_CODE = 1;

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
        vpadapter.addFragment(new Fragment_Alb(), "アルバム");
        vpadapter.addFragment(new Fragment_Art(), "アーティスト");
        vpadapter.addFragment(new Fragment_Fol(), "フォルダ");
        vpadapter.addFragment(new Fragment_Jan(), "ジャンル");
        viewPager.setAdapter(vpadapter);
        tabLayout.setupWithViewPager(viewPager);

//--------------------------------------------------------------------------------------------------
        //外部ストレージ使用のため、パーミッション設定（マニフェストにも、記述忘れずに）
        //oNCreate内にはいいている
        //パーミッションがあるか確認
        int permissionCheck = ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE);
        //値から許可を受けていない場合の処理
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            //1度拒否されたかの確認
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, READ_EXTERNAL_STORAGE)) {

            ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE}, REQUEST_CODE);
            } else {

//1回許可して、設定でOFFにした際にこちらのルートに入る
                Toast.makeText(this, "パーミッションが抹消されています。", Toast.LENGTH_SHORT).show();
               ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE}, REQUEST_CODE);

            }
        }
        //許可されている場合
        else {

        }
    }

        //--------------------------------------------------------------------------------------------------
        //oNCreate外にでていている
    @Override
    public void onRequestPermissionsResult ( int requestCode, String permissions[],int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            switch (requestCode) {
                //コードごとに場合分けすること
                case 1:
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        // パーミッションが必要な処理
                        Toast.makeText(this, "パーミッション追加しました", Toast.LENGTH_SHORT).show();
                    }else{

                    if(ActivityCompat.shouldShowRequestPermissionRationale(this, READ_EXTERNAL_STORAGE)) {
                        // パーミッションが得られなかった時
                        new AlertDialog.Builder(this).setTitle("カメラ機能の使用を許可してください")
                                .setMessage("カメラを利用するためには、機能を許可する必要があります。")
                                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{READ_EXTERNAL_STORAGE}, REQUEST_CODE);
                                    }
                                }).create().show();

                    }else{
                        new AlertDialog.Builder(this).setTitle("カメラ機能の使用するために下記のの通り設定してください")
                                .setMessage("①設定を開く\n②権限を選択\n③カメラをONにする")
                                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        //Fragmentの場合はgetContext().getPackageName()
                                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                                        intent.setData(uri);
                                        startActivity(intent);
                                    }
                                }).create().show();

                    }
                    break;
            }}
        }
//--------------------------------------------------------------------------------------------------


    }


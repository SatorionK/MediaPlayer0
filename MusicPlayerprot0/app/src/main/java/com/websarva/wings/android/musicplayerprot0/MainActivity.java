package com.websarva.wings.android.musicplayerprot0;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
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

    //パーミッションがあるか確認
    int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
    //値から許可を受けていないばあいの処理
        if(permissionCheck !=PackageManager.PERMISSION_GRANTED)

    {
        // 許可が必要な説明を表示するかの判定
        // ２回目以降「今後は確認しない」にチェックがない限りtrueになる
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, READ_EXTERNAL_STORAGE)) {

            Toast.makeText(this, "権限が許可されていません", Toast.LENGTH_SHORT).show();

        }
        // 初回、または、「今後は確認しない」にチェックがある
        // 「今後は確認しない」の場合、パーミッション追加のポップアップは出ないで
        // コールバックは強制的に失敗[PERMISSION_DENIED]を返してくるので注意
        else {

            ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE}, REQUEST_CODE);
        }
    }
    //許可されている場合
        else

    {
        Toast.makeText(this, "権限が許可されている！", Toast.LENGTH_SHORT).show();
    }

}
    //--------------------------------------------------------------------------------------------------
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // パーミッションが必要な処理
                    Toast.makeText(this, "パーミッション追加しました", Toast.LENGTH_SHORT).show();
                } else {
                    // パーミッションが得られなかった時
                    // 処理を中断する・エラーメッセージを出す・アプリケーションを終了する等
                    Toast.makeText(this, "パーミッション追加できませんでした。パーミッションがないと機能が使えませんよ！",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
//--------------------------------------------------------------------------------------------------
}


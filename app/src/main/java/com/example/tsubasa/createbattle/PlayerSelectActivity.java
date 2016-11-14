package com.example.tsubasa.createbattle;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import Const.CommonConst;
import Logic.BaseLogic;
import Logic.PlayerLogic;

public class PlayerSelectActivity extends AppCompatActivity {

    private int playerId1 = 0;
    private int playerId2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_select);

        // カメラボタンにクリックアクション設定
        Button btnCameraStart1 = (Button) findViewById(R.id.button_cameraStart1);
        btnCameraStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // カメラ画面に遷移
                Intent intent = new Intent(getApplication(), CameraActivity.class);
                startActivityForResult(intent, CommonConst.REQUEST_FOR_CAMERA_1);
            }
        });

        // カメラボタンにクリックアクション設定
        Button btnCameraStart2 = (Button) findViewById(R.id.button_cameraStart2);
        btnCameraStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // カメラ画面に遷移
                Intent intent = new Intent(getApplication(), CameraActivity.class);
                startActivityForResult(intent, CommonConst.REQUEST_FOR_CAMERA_2);
            }
        });
        // バトル開始ボタンにクリックアクション設定
        Button btnBattleStart = (Button) findViewById(R.id.button_battleStart);
        btnBattleStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), BattleActivity.class);
                //intent.putExtra("playerId1", playerId1);
                //intent.putExtra("playerId2", playerId2);
                int requestCode = CommonConst.RESULT_BATTLE_ACTIVITY;
                startActivityForResult(intent, requestCode);
            }
        });

        // プレイヤー選択ボタンにクリックアクション設定
        Button btnPlayerSelect = (Button) findViewById(R.id.button_playerSelect1);
        btnPlayerSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), PlayerListActivity.class);
                int requestCode = CommonConst.RESULT_PLAYER_LIST_ACTIVITY;
                startActivityForResult(intent, requestCode);
            }
        });
    }

    //返しの結果を受け取る
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        switch (requestCode) {
            //プレイヤー一覧からの結果取得
            case CommonConst.RESULT_PLAYER_LIST_ACTIVITY:
                //playerId1 = intent.getIntExtra("RESULT", 0);
                break;
            //バトル画面から結果取得
            case CommonConst.RESULT_BATTLE_ACTIVITY:
                break;
            // from cameraActivity 1
            case CommonConst.REQUEST_FOR_CAMERA_1:
                if(resultCode == CommonConst.CAMERA_ACTIVITY_RESULT_OK) {
                    ImageView iv1 = (ImageView) findViewById(R.id.player1);
                    String path1 = intent.getStringExtra("path");
                    iv1.setImageBitmap(PlayerLogic.setBitmapToView(path1, this, this));
                }
                break;
            // from cameraActivity 2
            case CommonConst.REQUEST_FOR_CAMERA_2:
                if(resultCode == CommonConst.CAMERA_ACTIVITY_RESULT_OK) {
                    ImageView iv2 = (ImageView) findViewById(R.id.player2);
                    String path2 = intent.getStringExtra("path");
                    iv2.setImageBitmap(PlayerLogic.setBitmapToView(path2, this, this));
                }
                break;

            default:
                break;
        }
    }
}

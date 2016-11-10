package com.example.tsubasa.createbattle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import Const.CommonConst;

public class PlayerSelectActivity extends AppCompatActivity {

    private int playerId1 = 0;
    private int playerId2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_select);

        // カメラボタンにクリックアクション設定
        Button btnCameraStart = (Button) findViewById(R.id.button_cameraStart);
        btnCameraStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // カメラ画面に遷移
                Intent intent = new Intent(getApplication(), CameraActivity.class);
                startActivity(intent);
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
            default:
                break;
        }
    }
}

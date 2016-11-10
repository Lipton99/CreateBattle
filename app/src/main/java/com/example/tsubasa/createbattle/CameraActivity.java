package com.example.tsubasa.createbattle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;

import Const.CommonConst;
import Logic.PlayerLogic;

public class CameraActivity extends AppCompatActivity {

    //カメラ取得画像設定View
    ImageView imageView;
    //顔情報
    HashMap<String, String> faceStatusData = new HashMap<String, String>();
    //Player情報
    HashMap<String, String> playerData = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //TODO
        Log.d("CreateBattle", "CameraActivity onCreate");

        //Viewレイアウト設定
        imageView = (ImageView) findViewById(R.id.image_view);

        // カメラボタンにクリックアクション設定
        Button cameraButton = (Button) findViewById(R.id.button_camera);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // カメラ起動
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                int requestCode = CommonConst.RESULT_CAMERA;
                startActivityForResult(intent, requestCode);
            }
        });

        // 画像決定ボタンにクリックアクション設定
        Button decisionButton = (Button) findViewById(R.id.button_decision_player);
        decisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //プレイヤー情報がある場合
                if (!playerData.isEmpty()) {
                    //プレイヤー情報をDBに登録する
                    PlayerModel playerModel = new PlayerModel(getApplicationContext());
                    playerModel.registPlayerData(playerData);
                }

                // プレイヤー選択画面に遷移
                Intent intent = new Intent(getApplication(), PlayerSelectActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CommonConst.RESULT_CAMERA) {
            //カメラで取得した画像取得
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            //カメラ画像あら顔情報取得
            faceStatusData = PlayerLogic.getFaceStatus(getApplicationContext(), bitmap);
            //顔情報がある場合
            if (!faceStatusData.isEmpty()) {
                //画像を保存する、保存先情報を追加
                faceStatusData = PlayerLogic.saveFileFaceBitmap(bitmap, faceStatusData);
                //顔情報からプレイヤーステータスを設定
                playerData = PlayerLogic.getStatusByFaseStatus(faceStatusData);
                //Viewに設定する
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
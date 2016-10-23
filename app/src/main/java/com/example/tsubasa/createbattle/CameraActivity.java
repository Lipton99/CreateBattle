package com.example.tsubasa.createbattle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import Const.CommonConst;
import Model.Player;

public class CameraActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

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
                // TODO:画像をDBに保存@mdlPlayerでプレイヤーデータ更新をする
                //Player mdlPlayer = Player.getInstance();

                // プレイヤー選択画面に遷移
                Intent intent = new Intent(getApplication(), PlayerSelectActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CommonConst.RESULT_CAMERA) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}



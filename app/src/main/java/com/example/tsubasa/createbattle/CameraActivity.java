package com.example.tsubasa.createbattle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

import Const.CommonConst;
import Model.Player;

public class CameraActivity extends AppCompatActivity {

    ImageView imageView;
    final int MAX_FACES = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //TODO
        Log.d("CreateBattle", "CameraActivity onCreate");

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
            //カメラで取得した画像のとりこみ
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            //顔認識クラス宣言
            FaceDetector detector = new FaceDetector.Builder(getApplicationContext())
                    .setTrackingEnabled(false)
                    .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                    .build();
            //カメラ画像に対して顔情報取得
            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<Face> face = detector.detect(frame);

            //顔の大きさ取得
            int size = face.size();
            Log.d("CreateBattle", "CameraActivity size = " + size);

            //顔認識された場合
            if (size > 0) {
                //画面にカメラ画像を設定する
                imageView.setImageBitmap(bitmap);
            }
        }

    }
}



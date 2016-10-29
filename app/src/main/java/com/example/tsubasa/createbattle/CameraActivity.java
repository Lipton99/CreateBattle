package com.example.tsubasa.createbattle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.Landmark;

import java.util.HashMap;
import java.util.List;

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
            //顔情報
            HashMap<String, String> faceStatusData = new HashMap<String, String>();
            //顔情報種別
            int faceType = 0;

            //カメラで取得した画像のとりこみ
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            //顔認識クラス宣言
            FaceDetector detector = new FaceDetector.Builder(getApplicationContext())
                    .setTrackingEnabled(false)
                    .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                    .build();

            //カメラ画像に対して顔情報取得
            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<Face> faces = detector.detect(frame);

            //顔数を取得
            int faceCount = faces.size();
            //顔認識された場合、
            if (faceCount > 0) {
                for (int i = 0; i < faces.size(); ++i) {
                    Face face = faces.valueAt(i);
                    //顔の詳細情報の取得
                    for (Landmark landmark : face.getLandmarks()) {
                        //顔情報種別の取得
                        faceType = landmark.getType();
                        //顔種別別にステータスを割り振る
                        switch (faceType) {
                            //口の位置
                            case Landmark.BOTTOM_MOUTH:
                                faceStatusData.put(String.valueOf(Landmark.BOTTOM_MOUTH), String.valueOf(landmark.getPosition()));
                                Log.d("CreateBattle", "CameraActivity BOTTOM_MOUTH = " + landmark.getPosition());
                                break;
                            //鼻の位置
                            case Landmark.NOSE_BASE:
                                faceStatusData.put(String.valueOf(Landmark.NOSE_BASE), String.valueOf(landmark.getPosition()));
                                Log.d("CreateBattle", "CameraActivity NOSE_BASE = " + landmark.getPosition());
                                break;
                            //左目の位置
                            case Landmark.LEFT_EYE:
                                faceStatusData.put(String.valueOf(Landmark.LEFT_EYE), String.valueOf(landmark.getPosition()));
                                Log.d("CreateBattle", "CameraActivity LEFT_EYE = " + landmark.getPosition());
                                break;
                            //右目の位置
                            case Landmark.RIGHT_EYE:
                                faceStatusData.put(String.valueOf(Landmark.RIGHT_EYE), String.valueOf(landmark.getPosition()));
                                Log.d("CreateBattle", "CameraActivity RIGHT_EYE = " + landmark.getPosition());
                                break;
                        }
                    }
                }
                //画面にカメラ画像を設定する
                imageView.setImageBitmap(bitmap);
            } else {
                //TODO:顔が取れていない場合は再度取得を促す
            }
        }
    }
}



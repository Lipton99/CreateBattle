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
import Model.PlayerModel;
import Logic.PlayerLogic;

public class CameraActivity extends AppCompatActivity {

    //カメラ取得画像設定View
    ImageView imageView;
    //顔情報
    HashMap<String, String> faceStatusData = new HashMap<String, String>();

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
            //カメラで取得した画像取得
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            //カメラ画像あら顔情報取得
            faceStatusData = PlayerLogic.getFaceStatus(bitmap);
            //顔情報がある場合
            if(!empty(faceStatusData)){
                //画像を保存する
                faceStatusData = PlayerLogic.saveFileFaceBitmap(bitmap,faceStatusData);       
                //Viewに設定する
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}



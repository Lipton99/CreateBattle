package com.example.tsubasa.createbattle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        //TODO
        Log.d("CreateBattle", "TitleActivity onCreate");

        // カメラボタンにクリックアクション設定
        Button btnCameraStart = (Button) findViewById(R.id.button_start);
        btnCameraStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // カメラ画面に遷移
                Intent intent = new Intent(getApplication(), PlayerSelectActivity.class);
                startActivity(intent);
            }
        });
    }
}

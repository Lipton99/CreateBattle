package com.example.tsubasa.createbattle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO
        Log.d("CreateBattle", "MainActivity onCreate");

        // インテントの生成
        Intent intent = new Intent(getApplication(), TitleActivity.class);
        startActivity(intent);

    }
}

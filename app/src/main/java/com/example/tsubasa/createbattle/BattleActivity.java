package com.example.tsubasa.createbattle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BattleActivity extends AppCompatActivity {
    
    //プレイヤー1情報
    HashMap<String, String> playerData1 = new HashMap<String, String>();
    //プレイヤー2情報
    HashMap<String, String> playerData2 = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        
        //TODO:mockPlayerData@本来はDBからPlayerIDで取得する
        Player player1 = TestMockLogic.createPlayerDataMock("モック1",9999);
        Player player2 = TestMockLogic.createPlayerDataMock("モック2",9998);
        
    }
}

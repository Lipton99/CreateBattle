package Logic;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.jar.Manifest;

/**
 * Created by Tsubasa on 2016/11/16.
 * 開発用テスト用ロジック（本番では使用しない）
 */
public class TestMockLogic {

    /**
     * プレイヤー情報モックの作成
     * @param playerName プレイヤー名
     * @param playerId プレイヤーID
     */
    public static HashMap<String, String> createPlayerDataMock(String playerName,Integer playerId) {
        
        //Randomクラスの生成（シード指定なし）
        Random random = new Random();
        Integer randomValue = random.nextInt(10000) + 10000;
    
        //モックプレイヤー情報の設定値
        HashMap<String, String> playerData = new HashMap<String, String>();
        //引数のプレイヤー名前
        playerData.put(Player.COLUMN_PLAYER_NAME,  playerName);
        //削除フラグは0固定
        playerData.put(Player.COLUMN_PLAYER_DEL_FLAG,  0);
        //プレイヤーID
        playerData.put(Player.COLUMN_PLAYER_NAME,  playerId);
        
        
        /* 以下設定値はランダムとする */
        playerData.put(Player.COLUMN_PLAYER_HP,  Integer.toString(random.nextInt(10000) + 10000));
        playerData.put(Player.COLUMN_PLAYER_ATK,  Integer.toString(random.nextInt(1000) + 1000));
        playerData.put(Player.COLUMN_PLAYER_DEF,  Integer.toString(random.nextInt(1000) + 1000));
        playerData.put(Player.COLUMN_PLAYER_JOB,  Integer.toString(random.nextInt(3)));
        playerData.put(Player.COLUMN_PLAYER_STATUS,  Integer.toString(random.nextInt(3)));
        
        Player player = new Player(playerData);

        return player;
    }
}

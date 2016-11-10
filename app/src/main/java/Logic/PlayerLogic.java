package Logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.Landmark;

import java.io.IOException;
import java.util.HashMap;

import Const.CommonConst;
import Logic.BaseLogic;

public class PlayerLogic {

    /**
     * BitMap情報から顔情報を取得する
     *
     * @param bitmap Bitmap画像
     */
    public static HashMap<String, String> getFaceStatus(Context context, Bitmap bitmap) {
        //顔情報
        HashMap<String, String> faceStatusData = new HashMap<String, String>();
        //顔情報種別
        int faceType = 0;

        //顔認識クラス宣言
        FaceDetector detector = new FaceDetector.Builder(context)
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
        }
        return faceStatusData;
    }

    /**
     * BitMapの保存
     *
     * @param bitmap         Bitmap画像
     * @param faceStatusData 顔情報
     */
    public static HashMap<String, String> saveFileFaceBitmap(Bitmap bitmap, HashMap<String, String> faceStatusData) {
        //保存ディレクトリパス
        String dirPath = CommonConst.FACE_BITMAP_FILE_PATH;
        //保存ファイルパス
        String filePath = "";

        //指定ディレクトリ配下にBitmaを保存
        try {
            filePath = BaseLogic.saveBitmap(bitmap, dirPath);
        } catch (IOException e) {
            Log.e("CreateBattle", "CameraActivity saveFileFaceBitmap failed saveBitmap()");
            e.printStackTrace();
        }

        //ファイルパスを顔情報に追加する
        faceStatusData.put("face_bitmap_file_path", filePath);

        return faceStatusData;
    }

    /**
     * /**
     * プレイヤーステータス算出
     *
     * @param faceStatusData 顔情報
     */
    public static HashMap<String, String> getStatusByFaseStatus(HashMap<String, String> faceStatusData) {
        HashMap<String, String> playerData = new HashMap<String, String>();

        //顔情報で初期化
        int playerHp = faceStatusData.get(String.valueOf(Landmark.BOTTOM_MOUTH));
        int playerAtk = faceStatusData.get(String.valueOf(Landmark.RIGHT_EYE));
        int playerDef = faceStatusData.get(String.valueOf(Landmark.LEFT_EYE));
        int playerJob = faceStatusData.get(String.valueOf(Landmark.NOSE_BASE));
        int playerStatus = faceStatusData.get(String.valueOf(Landmark.BOTTOM_MOUTH));

        //プレイヤーステータス計算
        playerHp = Math.ceil(playerHp * 10000);
        playerAtk = Math.ceil(playerAtk * 100);
        playerDef = Math.ceil(playerDef * 100);

        //職業設定
        playerJob = Math.ceil(playerJob);

        //状態異常設定
        playerStatus = Math.ceil(playerStatus);

        //職業設定
        playerJob = Math.ceil(playerJob);

        //状態異常設定
        playerStatus = Math.ceil(playerStatus);

        //計算値の設定
        playerData.put(Player.COLUMN_PLAYER_HP, playerHp);
        playerData.put(Player.COLUMN_PLAYER_ATK, playerAtk);
        playerData.put(Player.COLUMN_PLAYER_DEF, playerDef);
        playerData.put(Player.COLUMN_PLAYER_JOB, playerJob);
        playerData.put(Player.COLUMN_PLAYER_STATUS, playerStatus);

        return playerData;
    }
}


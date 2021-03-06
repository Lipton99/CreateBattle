package Const;

/**
 * Created by Tsubasa on 2016/10/23.
 */
public class CommonConst {
    /* ActivityConst*/
    //カメラ画面遷移結果
    public final static int RESULT_CAMERA = 1000;
    // request for CameraActivity 1
    public static final int REQUEST_FOR_CAMERA_1 = 1001;
    // request for CameraActivity 2
    public static final int REQUEST_FOR_CAMERA_2 = 1002;
    // result ok from CameraActivity
    public static final int CAMERA_ACTIVITY_RESULT_OK = 1111;
    //プレイヤー一覧画面遷移結果
    public final static int RESULT_PLAYER_LIST_ACTIVITY = 3000;
    //バトル画面遷移結果
    public final static int RESULT_BATTLE_ACTIVITY = 4000;

    /* LogicConst */
    //顔画像保存先ディレクトリ(相対パス)
    public final static String FACE_BITMAP_FILE_PATH = "/data/faceBitmap/";

    /* UtilityConst */
    //DB名
    public final static String DATABASE_NAME = "createBattle.db";
    //DB version
    public final static int DATABASE_VERSION = 1;

}

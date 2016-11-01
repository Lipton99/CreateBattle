package Const;

/**
 * Created by Tsubasa on 2016/10/23.
 */
public class CommonConst {
    /* ActivityConst*/
    //カメラ画面遷移結果
    public final static int RESULT_CAMERA = 1000;
    //プレイヤー一覧画面遷移結果
    public final static int RESULT_PLAYER_LIST_ACTIVITY = 3000;
    //バトル画面遷移結果
    public final static int RESULT_BATTLE_ACTIVITY = 4000;
    
    /* LogicConst */
    //顔画像保存先ディレクトリ
    public final static String FACE_BITMAP_FILE_PATH = "./data/faceBitmap/";
    
    /* UtilityConst */
    public static final String DATABASE_NAME = "createBattle.db";
	public static final int DATABASE_VERSION = 1;

}

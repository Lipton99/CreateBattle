package Model.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.HashMap;

/**
 * Created by Tsubasa on 2016/11/01.
 */
@DatabaseTable(tableName = Player.TABLE_NAME)
public class Player {
    //テーブル名
    public static final String TABLE_NAME = "player_info";
    /* カラム名 */
    //プレイヤーID
    public static final String COLUMN_PLAYER_ID = "player_id";
    //プレイヤー名
    public static final String COLUMN_PLAYER_NAME = "player_name";
    //HP
    public static final String COLUMN_PLAYER_HP = "player_hp";
    //攻撃力
    public static final String COLUMN_PLAYER_ATK = "player_atk";
    //防御力
    public static final String COLUMN_PLAYER_DEF = "player_def";
    //職業
    public static final String COLUMN_PLAYER_JOB = "player_job";
    //特殊ステータス
    public static final String COLUMN_PLAYER_STATUS = "player_status";
    //削除フラグ
    public static final String COLUMN_PLAYER_DEL_FLAG = "del_flag";

    /* テーブル定義 */
    @DatabaseField(generatedId = true, columnName = COLUMN_PLAYER_ID)
    private Integer userId;
    @DatabaseField(columnName = COLUMN_PLAYER_NAME)
    private String playerName;
    @DatabaseField(columnName = COLUMN_PLAYER_HP)
    private Integer playerHp;
    @DatabaseField(columnName = COLUMN_PLAYER_ATK)
    private Integer playerAtk;
    @DatabaseField(columnName = COLUMN_PLAYER_DEF)
    private Integer playerDef;
    @DatabaseField(columnName = COLUMN_PLAYER_JOB)
    private Integer playerJob;
    @DatabaseField(columnName = COLUMN_PLAYER_STATUS)
    private Integer playerStatus;
    @DatabaseField(columnName = COLUMN_PLAYER_DEL_FLAG)
    private Integer playerDelFlag;

    //未使用
    public Player() {
    }

    public Player(HashMap<String, String> playerData) {
        //プレイヤー名
        if (playerData.containsKey(COLUMN_PLAYER_NAME)) {
            this.playerName = playerData.get(COLUMN_PLAYER_NAME);
        } else {
            this.playerName = "";
        }
        //HP
        if (playerData.containsKey(COLUMN_PLAYER_HP)) {
            this.playerHp = Integer.parseInt(playerData.get(COLUMN_PLAYER_HP));
        } else {
            this.playerHp = 0;
        }
        //攻撃力
        if (playerData.containsKey(COLUMN_PLAYER_ATK)) {
            this.playerAtk = Integer.parseInt(playerData.get(COLUMN_PLAYER_ATK));
        } else {
            this.playerAtk = 0;
        }
        //防御力
        if (playerData.containsKey(COLUMN_PLAYER_DEF)) {
            this.playerDef = Integer.parseInt(playerData.get(COLUMN_PLAYER_DEF));
        } else {
            this.playerDef = 0;
        }
        //職業
        if (playerData.containsKey(COLUMN_PLAYER_JOB)) {
            this.playerJob = Integer.parseInt(playerData.get(COLUMN_PLAYER_JOB));
        } else {
            this.playerJob = 0;
        }
        //特殊ステータス
        if (playerData.containsKey(COLUMN_PLAYER_STATUS)) {
            this.playerStatus = Integer.parseInt(playerData.get(COLUMN_PLAYER_STATUS));
        } else {
            this.playerStatus = 0;
        }
        //削除フラグ
        if (playerData.containsKey(COLUMN_PLAYER_DEL_FLAG)) {
            this.playerDelFlag = Integer.parseInt(playerData.get(COLUMN_PLAYER_DEL_FLAG));
        } else {
            this.playerDelFlag = 0;
        }
    }
}

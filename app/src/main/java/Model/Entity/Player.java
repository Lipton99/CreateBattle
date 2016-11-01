package Model.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

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
	@DatabaseField(generatedId = true, columnName = COLUMN_USER_ID)
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

	public Player(Integer userId, String playerName,Integer playerHp,Integer playerAtk,Integer playerDef,Integer playerJob,Integer playerStatus,Integer playerDelFlag) {
		this.userId = userId;
		this.playerName = playerName;
		this.playerHp = playerHp;
		this.playerAtk = playerAtk;
		this.playerDef = playerDef;
		this.playerJob = playerJob;
		this.playerStatus = playerStatus;
		this.playerDelFlag = playerDelFlag;
	}
}

package Model;

/**
 * Created by Tsubasa on 2016/10/23.
 */

public class PlayerModel {
	private Context context;
	public PlayerModel(Context context) {
		this.context = context;
	}
    
     /**
	 * updateする
	 * @param player 対象のエンティティ
     * @param updateParam 更新内容
	 */
    private void updatePlayerData(Player player, List updateParam) {
        DatabaseHelper helper = new DatabaseHelper(context);
		try {
			Dao<Player, Integer> dao = helper.getDao(Player.class);
			//TODO:更新処理
			//dao.createOrUpdate(player);
		} catch (Exception e) {
			Log.d("PlayerModel", "updatePlayerData Failed");
		} finally {
			helper.close();
		}
    }

    /**
	 * selectする
	 * @param word 対象のエンティティ
	 */
    private void findByPlayerId() {
        DatabaseHelper helper = new DatabaseHelper(context);

    }

    /**
	 * insert する
	 * @param word 対象のエンティティ
	 */
    private void registPlayerData() {
        DatabaseHelper helper = new DatabaseHelper(context);

    }

}

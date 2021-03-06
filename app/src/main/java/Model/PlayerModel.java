package Model;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.util.HashMap;
import java.util.List;

import Model.Entity.Player;
import Utility.DatabaseHelper;

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
     *
     * @param playerId    プレイヤーID
     * @param updateParam 更新内容
     */
    private void updatePlayerData(Integer playerId, HashMap<String, String> updateParam) {
        //TODO:対象プレイヤーの情報取得
        //findByPlayerId(playerId);

        //TODO:取得情報を元に更新情報を設定

        //更新情報の設定
        Player player = new Player(updateParam);
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<Player, Integer> dao = helper.getDao(Player.class);
            //TODO:更新処理
            dao.createOrUpdate(player);
        } catch (Exception e) {
            Log.d("PlayerModel", "updatePlayerData Failed");
        } finally {
            helper.close();
        }
    }

    /**
     * selectする
     *
     * @param playerId プレイヤーID
     */
    private List<Player> findByPlayerId(Integer playerId) {
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<Player, Integer> dao = helper.getDao(Player.class);
            return dao.queryForAll();
        } catch (Exception e) {
            Log.d("PlayerModel", "findByPlayerId Failed");
        } finally {
            helper.close();
        }
        return null;
    }

    /**
     * insert する
     *
     * @param param 登録情報
     */
    public void registerPlayerData(HashMap<String, String> param) {
        //登録情報の設定
        Player player = new Player(param);
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<Player, Integer> dao = helper.getDao(Player.class);
            //登録処理
            dao.createOrUpdate(player);
        } catch (Exception e) {
            Log.e("PlayerModel", "registerPlayerData Failed");
            e.printStackTrace();
        } finally {
            helper.close();
        }
    }
}

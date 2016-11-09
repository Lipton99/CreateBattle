package Model;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

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
     * @param player      対象のエンティティ
     * @param updateParam 更新内容
     */
    private void updatePlayerData(List updateParam) {
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
     * @param player 対象のエンティティ
     */
    private void findByPlayerId(Player player) {
        DatabaseHelper helper = new DatabaseHelper(context);

    }

    /**
     * insert する
     * @param player 対象のエンティティ
     */
    private void registPlayerData(Player player) {
        DatabaseHelper helper = new DatabaseHelper(context);

    }

}

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
    private void updatePlayerData(Int playerId , HashMap<String, String> updateParam) {
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
     * @param player 対象のエンティティ
     */
    private void findByPlayerId(Int playerId) {
        DatabaseHelper helper = new DatabaseHelper(context);
            try {
                Dao<Word, Integer> dao = helper.getDao(Player.class);
                return dao.queryForAll();
            }catch (Exception e) {
                Log.d("PlayerModel", "findByPlayerId Failed");
            } finally {
            helper.close();
        }
    }

    /**
     * insert する
     * @param player 対象のエンティティ
     */
    private void registPlayerData(HashMap<String, String> registParam) {
        //登録情報の設定
        Player player = new Player(registParam);
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<Player, Integer> dao = helper.getDao(Player.class);
            //登録処理
            dao.createOrUpdate(player);
        } catch (Exception e) {
            Log.d("PlayerModel", "registPlayerData Failed");
        } finally {
            helper.close();
        }

    }

}

package Utility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import Const.CommonConst;
import Model.Entity.Player;

import java.sql.SQLException;

/**
 * Created by Tsubasa on 2016/11/01.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, CommonConst.DATABASE_NAME, null, CommonConst.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Player.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "データベースを作成できませんでした", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

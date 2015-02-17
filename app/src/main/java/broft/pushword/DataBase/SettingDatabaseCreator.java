package broft.pushword.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 태욱 on 2015-02-12.
 */
public class SettingDatabaseCreator extends SQLiteOpenHelper {
    // 데이터베이스 생성
    public SettingDatabaseCreator(Context context, String name, SQLiteDatabase.CursorFactory factory,
                              int version) {
        super(context, name, factory, version);
    }
    // 테이블 생성
    public void onCreate(SQLiteDatabase db) {
        Log.i("xxx", "onCreate >>>>>>>>>>>>>>>.....");

        String sql = "create table setting ( " +
                " _id integer primary key autoincrement , " +
                " name text , " +
                " age integer , " +
                " address text )";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("xxx", "onUpgrade >>>>>>>>>>>>>>>.....");

        String sql = "drop table if exists person";
        db.execSQL(sql);

        onCreate(db);
    }
}
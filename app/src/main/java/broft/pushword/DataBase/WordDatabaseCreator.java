package broft.pushword.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 태욱 on 2015-02-12.
 */
public class WordDatabaseCreator extends SQLiteOpenHelper {
    // 데이터베이스 생성
    public WordDatabaseCreator(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, factory, version);
    }
    // 테이블 생성
    public void onCreate(SQLiteDatabase db) {
        Log.i("DB", "Creating word set table..");

        String sql = "create table wordset (" +
                "_id integer primary key autoincrement, " +
                "word text, " +
                "meaning text, " +
                "level integer, " +
                "pass integer);";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists wordset";
        db.execSQL(sql);
        onCreate(db);
    }
}
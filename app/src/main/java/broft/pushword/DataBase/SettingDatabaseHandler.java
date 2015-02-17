package broft.pushword.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 태욱 on 2015-02-12.
 */
public class SettingDatabaseHandler  {
    SettingDatabaseCreator helper;
    SQLiteDatabase db;

    // 초기화 작업
    public SettingDatabaseHandler(Context context) {
        helper = new SettingDatabaseCreator(context, "sample.sqlite", null, 1);
    }
    //open
    public static SettingDatabaseHandler open(Context context) {
        return new SettingDatabaseHandler(context);
    }

    //close
    public void close() {
        db.close();
    }

    //저장
    public void insert(String name, int age, String address) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("address", address);
        db.insert("wordset", null, values);

    }//end insert

    //수정
    public void update(String name, int age) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", age);
        db.update("person", values, "name=?", new String[]{name});
    }//end update

    //삭제
    public void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("person", "name=?", new String[]{name});
    }//end delete

    //검색
    public Cursor select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("person", null, null, null, null, null, null);
        return c;
    }
}
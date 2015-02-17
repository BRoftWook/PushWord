package broft.pushword.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 태욱 on 2015-02-12.
 */
public class WordDatabaseHandler  {
    WordDatabaseCreator helper;
    SQLiteDatabase db;

    // 초기화 작업
    public WordDatabaseHandler(Context context) {
        helper = new WordDatabaseCreator(context, "sample.sqlite", null, 1);
    }
    //open
    public static WordDatabaseHandler open(Context context) {
        return new WordDatabaseHandler(context);
    }
    //close
    public void close() {
        db.close();
    }

    //Convert word set file ( in txt file format) to Database file
    public void insert(String word, String meaning) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("word", word);
        values.put("meaning", meaning);
        values.put("level", 2);
        values.put("pass", 0);
        db.insert("wordset", null, values);
    }//end insert

    //수정
    public void update(String name, int age) {
//        db = helper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("age", age);
//        db.update("person", values, "name=?", new String[]{name});
    }//end update

    //TODO: 삭제 수정
    public void delete(String word) {
        db = helper.getWritableDatabase();
        db.delete("wordset", word, new String[]{word});
    }//end delete

    //TODO: 검색 수정
    public Cursor select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("wordset", null, null, null, null, null, null);
        return c;
    }
}
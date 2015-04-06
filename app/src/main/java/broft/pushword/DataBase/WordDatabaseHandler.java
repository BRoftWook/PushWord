package broft.pushword.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by 태욱 on 2015-02-12.
 */
public class WordDatabaseHandler  {
    static WordDatabaseCreator helper;
    static SQLiteDatabase db;

    // 초기화 작업
    public WordDatabaseHandler(Context context) {
        helper = new WordDatabaseCreator(context, "wordDB.db", null, 1);
        Log.i("Word DB","Word DB Created..");
    }
    //close
    public void close() {
        db.close();
    }

    //단어장 테이블을 만들 때 쓰는 함수
    public void insert(String word, String meaning) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("word", word);
        values.put("meaning", meaning);
        values.put("level", 2);
        values.put("pass", 0);
        db.insert("wordset", null, values);
        Log.i("Word DB",values.toString());
    }

    //단어 등급, 테스트 통과 여부 수정
    public void update(int id, int level, int pass) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("level",level);
        values.put("pass",pass);
        db.update("wordset", values, "_id="+id, null);
    }

    //주어진 인덱스의 단어를 찾는 함수
    public Cursor select(int id) {
        db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT word FROM wordset WHERE _id='"+id+"'",null);
        return c;
    }
    //TODO : 푸쉬 할 단어의 인덱스를 골라주는 함수
    public void pushWordSelector(){

    }
    //TODO : (현재 단어장) => (학습 진행률) 을 구하는 함수
    public void learningProgress(){

    }
}
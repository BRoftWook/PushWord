package broft.pushword;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import broft.pushword.DataBase.WordDatabaseCreator;
import broft.pushword.DataBase.WordDatabaseHandler;

/**
 * Created by 태욱 on 2015-01-28.
 */
public class TestActivity extends ActionBarActivity {
    EditText inputWord;
    EditText inputMeaning;
    EditText wordId;
    WordDatabaseHandler db;
    TextView searchResult;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_test);
        db = new WordDatabaseHandler(context);
        inputWord = (EditText)findViewById(R.id.word);
        inputMeaning = (EditText)findViewById(R.id.meaning);
        Button insertButton = (Button)findViewById(R.id.insert);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word;
                String meaning;
                word = inputWord.getText().toString().trim();
                meaning = inputMeaning.getText().toString().trim();
                db.insert(word,meaning);
                Toast.makeText(context,"Insert Success",Toast.LENGTH_SHORT);
            }
        });
        wordId = (EditText)findViewById(R.id.wordid);
        searchResult = (TextView)findViewById(R.id.searchresult);
        Button searchButton = (Button)findViewById(R.id.search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(wordId.getText().toString().trim());
                Cursor c = db.select(id);
                System.out.println(c.getString(0));
//                searchResult.setText(c.getColumnCount());
            }
        });
    }
}
package broft.pushword;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by 태욱 on 2015-02-16.
 */
public class PushActivity extends Activity {
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO : 단어장 DB에 접근해서 Push할 단어들 가져오는 Controller 클래스 따로 구현 필요
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Bundle bun = getIntent().getExtras();
//        message = bun.getString("message");
        String[] pushword = {"word1", "word2", "word3"};

        setContentView(R.layout.activity_push);

        ListView list = (ListView) findViewById(R.id.pushword_list);
        list.setItemsCanFocus(false);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, pushword);
        list.setAdapter(adapter);
        //TODO : 익숙 / 낯선으로 체크박스 두 줄로 구현

        Button button = (Button)findViewById(R.id.push_message_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //TODO ; DB에 접근해서 단어 LEVEL 수정하는 부분 필요
            }
        });
    }
}

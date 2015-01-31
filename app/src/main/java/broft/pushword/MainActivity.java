package broft.pushword;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView currentWordSet = (TextView)findViewById(R.id.wordset_name);
        //TODO: 텍스트뷰와 DB 연결
        ProgressBar learningProgress = (ProgressBar)findViewById(R.id.progressBar);
        //TODO: 프로그레스바와 DB 연결

        Button settingButton = (Button)findViewById(R.id.setting_button);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingActivity.class));
            }
        });
        Button testButton = (Button)findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TestActivity.class));
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Log.i("YJ", "OnStart");
    }
}

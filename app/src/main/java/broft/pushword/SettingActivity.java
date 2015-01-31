package broft.pushword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import Service.LockScreenService;
/**
 * Created by 태욱 on 2015-01-28.
 */
public class SettingActivity extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//TODO: 쉐어드 프리퍼런스로 설정 지정 및 저장
        final Switch lockScreenSwitch = (Switch)findViewById(R.id.switch_lockscreen);
        lockScreenSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lockScreenSwitch.isChecked() == false){
                    lockScreenSwitch.toggle();
                    startService(new Intent(getApplicationContext(),LockScreenService.class));
                }
                else{
                    lockScreenSwitch.toggle();
                    stopService(new Intent(getApplicationContext(),LockScreenService.class));
                }
            }
        });

        final Switch pushSwitch = (Switch)findViewById(R.id.switch_push);
        pushSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        EditText pushStartTime = (EditText)findViewById(R.id.push_start_time);

        EditText pushEndTime =(EditText)findViewById(R.id.push_end_time);

        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button returnButton = (Button)findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}

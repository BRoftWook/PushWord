package broft.pushword.BroadcastReceiver;

/**
 * Created by 태욱 on 2015-01-31.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) //10초마다 이리루 들어옵니다
    {
        Toast.makeText(context, "hi", Toast.LENGTH_LONG).show();
    }
}

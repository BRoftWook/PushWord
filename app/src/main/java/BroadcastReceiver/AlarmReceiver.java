package BroadcastReceiver;

/**
 * Created by 태욱 on 2015-01-31.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
            Log.i("YJ","Screen ON");
    }
}

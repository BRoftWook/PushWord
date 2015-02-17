package broft.pushword.BroadcastReceiver;

/**
 * Created by 태욱 on 2015-01-31.
 */
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import broft.pushword.LockScreenActivity;

public class ScreenReceiver extends BroadcastReceiver {
    public ScreenReceiver() {
    }

   // private KeyguardManager km;
   // private KeyguardManager.KeyguardLock keyLock;

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Log.i("YJ", "Screen OFF");
            Intent i = new Intent(context, LockScreenActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Log.i("YJ","Screen ON");
            Intent i = new Intent(context, LockScreenActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
package broft.pushword;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by 태욱 on 2015-01-28.
 */
public class LockScreenActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockscreen);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                |WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                |WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    }
}
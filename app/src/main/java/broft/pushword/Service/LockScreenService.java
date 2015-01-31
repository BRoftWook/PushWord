package broft.pushword.Service;

/**
 * Created by 태욱 on 2015-01-31.
 */
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import broft.pushword.BroadcastReceiver.ScreenReceiver;

public class LockScreenService extends Service {
    public LockScreenService() {
    }
    ScreenReceiver mReceiver;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mReceiver = new ScreenReceiver();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        IntentFilter screenStateFilter = new IntentFilter();
        screenStateFilter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(mReceiver,screenStateFilter);
        Log.i("YJ", "스크린 감지 서비스 시작!");
        return START_STICKY;  //시스템이 죽여도 다시 살린다!
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(mReceiver);
        Log.i("YJ", "스크린 감지 서비스 끝남!");
    }
}
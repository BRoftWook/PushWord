package broft.pushword.Service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import broft.pushword.PushActivity;

/**
 * Created by 태욱 on 2015-01-31.
 */
public class PushAlarmService extends Service {

    public PushAlarmService(){
    }
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        setAlarm();
        Log.i("YJ", "푸쉬 서비스 시작!");
        return START_STICKY;  //시스템이 죽여도 다시 살린다!
    }

    public void setAlarm(){
        //TODO: 푸쉬 시간 설정하는 로직 필요
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(PushAlarmService.this, PushActivity.class);
        PendingIntent pender = PendingIntent.getActivity(getApplicationContext(),0,intent,0);
        long firstTime = SystemClock.elapsedRealtime();
        alarm.setRepeating(AlarmManager.ELAPSED_REALTIME, firstTime ,5*1000 ,pender);
    }

    @Override
    public void onDestroy() {
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(PushAlarmService.this, PushActivity.class);
        PendingIntent pender = PendingIntent.getActivity(getApplicationContext(),0,intent,0);
        pender.cancel();
        super.onDestroy();
    }
    @Override
    public IBinder onBind(Intent intent) {throw new UnsupportedOperationException("Not yet implemented");}
}
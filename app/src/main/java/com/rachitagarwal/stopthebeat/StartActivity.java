package com.rachitagarwal.stopthebeat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.rachitagarwal.stopthebeat.R.layout.activity_start);

        TextView mRunningText = (TextView) findViewById(com.rachitagarwal.stopthebeat.R.id.stopbeat_running_text);

        Bundle variables = getIntent().getExtras();
        if (variables==null) return;

        int hours = variables.getInt("hours");
        int minutes = variables.getInt("minutes");
        int seconds = variables.getInt("seconds");

        //sendNotification();

        String runningText = "StopBeat is now running. Your music will stop in " +
                hours + " hours, " + minutes + " minutes" + ", and " + seconds + " seconds.";
        mRunningText.setText(runningText);

        new Handler().postDelayed(new Runnable() { public void run() {
            AudioManager mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

            if (mAudioManager.isMusicActive()) {

                Intent i = new Intent("com.android.music.musicservicecommand");

                i.putExtra("command", "pause");
                StartActivity.this.sendBroadcast(i);
            }
        }
        }, ((1000 * seconds) + (1000 * 60 * minutes) + (1000 * 60 * 60 * hours)));

    }

    /*
    private void sendNotification() {
        Notification.Builder builder = new Notification.Builder(context)
                .setContentTitle("StopBeat is currently running")
                .setContentText("Stopping music soon...")
                .setSmallIcon(R.drawable.ic_action_picture)
                .addAction(R.drawable.ic_launcher_stop, "STOP", notificationIntent);
        Notification stopBeatNotification = builder.build();

        stopBeatNotification.flags |= Notification.FLAG_NO_CLEAR | Notification.FLAG_ONGOING_EVENT;

        notificationManager.notify(NOTIFICATION_ID, n);

    }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.rachitagarwal.stopthebeat.R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.rachitagarwal.stopthebeat.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

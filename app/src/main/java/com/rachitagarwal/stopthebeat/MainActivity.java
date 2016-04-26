package com.rachitagarwal.stopthebeat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    int hours;
    int minutes;
    int seconds;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.rachitagarwal.stopthebeat.R.layout.activity_main);

        final EditText mEditHours = (EditText) findViewById(com.rachitagarwal.stopthebeat.R.id.editHours);
        final EditText mEditMinutes = (EditText) findViewById(com.rachitagarwal.stopthebeat.R.id.editMinutes);
        final EditText mEditSeconds = (EditText) findViewById(com.rachitagarwal.stopthebeat.R.id.editSeconds);
        Button mMainStart = (Button) findViewById(com.rachitagarwal.stopthebeat.R.id.mainStart);

        mMainStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                intent.putExtra("hours", Integer.parseInt(mEditHours.getText().toString()));
                intent.putExtra("minutes", Integer.parseInt(mEditMinutes.getText().toString()));
                intent.putExtra("seconds", Integer.parseInt(mEditSeconds.getText().toString()));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.rachitagarwal.stopthebeat.R.menu.menu_main, menu);
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

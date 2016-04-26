package com.rachitagarwal.stopthebeat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;


public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.rachitagarwal.stopthebeat.R.layout.activity_welcome);

        final TextView mWelcomeText = (TextView) findViewById(com.rachitagarwal.stopthebeat.R.id.welcomeText);
        final TextView mWelcomeDescription = (TextView) findViewById(com.rachitagarwal.stopthebeat.R.id.welcomeDescription);
        final Button mWelcomeStart;
        mWelcomeStart = (Button) findViewById(com.rachitagarwal.stopthebeat.R.id.mainStart);

        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f );

        mWelcomeText.startAnimation(fadeIn);
        try{ Thread.sleep(1000); }catch(InterruptedException e){ };
        mWelcomeDescription.startAnimation(fadeIn);
        try{ Thread.sleep(1000); }catch(InterruptedException e){ };
        mWelcomeStart.startAnimation(fadeIn);

        fadeIn.setDuration(1200);
        fadeIn.setFillAfter(true);

        mWelcomeStart.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View v)
            {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.rachitagarwal.stopthebeat.R.menu.menu_welcome, menu);
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

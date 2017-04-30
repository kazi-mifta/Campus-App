package com.campusapp.cuet;

import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;


//Splash Screen Is The One Which You See When You Click The App, A window pop ups but The App hasn't just started yet.
//It Let Users See Something When The App is Loading It's Contents in BackYard.
public class SplashActivity extends AppCompatActivity {

    private PrefManager prefManager;
    @Override
    protected void onStart() {
        super.onStart();

        prefManager = new PrefManager(this);
        if(!prefManager.isFirstTimeLaunch()){
            TaskStackBuilder.create(this)
                    .addNextIntent(new Intent(this, MainActivity.class))
                    .startActivities();
            prefManager.setFrstTimeLaunch(false);

        }

        else{
            TaskStackBuilder.create(this)
                    .addNextIntentWithParentStack(new Intent(this, MainActivity.class))
                    .addNextIntent(new Intent(this, IntroActivity.class))
                    .startActivities();

            prefManager.setFrstTimeLaunch(false);
        }
    }
}
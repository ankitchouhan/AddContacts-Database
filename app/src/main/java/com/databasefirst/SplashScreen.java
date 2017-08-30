package com.databasefirst;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.databasefirst.adapters.PageAdapter;
import com.databasefirst.database.SharedPref;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will invoke once timer is over.

                if(new SharedPref(getApplicationContext()).isLoggedin())
                {
                    Intent intent = new Intent(SplashScreen.this,SignedIn.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_TIME_OUT);

    }
}

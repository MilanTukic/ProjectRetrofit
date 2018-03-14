package com.example.tukic.projectretrofit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.tukic.projectretrofit.R;


public class SplashScreenActivity extends AppCompatActivity {

    private final String LOG_TAG = SplashScreenActivity.this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3 * 1000);
                    openMainActivity();
                } catch (InterruptedException e) {
                    Log.e(LOG_TAG, "Error displaying the splash screen: " + e.getStackTrace());
                }
            }
        }).start();
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

package com.example.tutorials_utc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        progressBar = (ProgressBar) findViewById(R.id.ProgressBar);
        //Hide for STATUS BAR HIDE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        // END
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ValuerText();
            }
        });
        thread.start();

    }

    void ValuerText() {
        for (int i = 20; i != 100; ) {
            i = i + 20;
            try {
                Thread.sleep(1000);
                progressBar.setProgress(i);


                if (i == 100) {
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                    finish();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
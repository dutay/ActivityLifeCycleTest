package com.example.activitylifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.tag(TAG).d("onCreate");
        setContentView(R.layout.activity_main);
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.tag(TAG).d("onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.tag(TAG).d("onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.tag(TAG).d("onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.tag(TAG).d("onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.tag(TAG).d("onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Timber.tag(TAG).d("onRestart");

    }

}

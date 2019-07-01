package com.example.activitylifecycletest;

import android.os.Bundle;
import android.view.View;

import timber.log.Timber;

public class SecondActivity extends BaseActivity {
    public static final String TAG = SecondActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.tag(TAG).d("Task id is " + getTaskId());
        setContentView(R.layout.activity_second);
        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.getInstance().finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

    }

}

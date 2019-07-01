package com.example.activitylifecycletest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import timber.log.Timber;

public class FirstActivity extends BaseActivity {

    public static final String TAG = FirstActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.tag(TAG).d("Task id is " + getTaskId());
        setContentView(R.layout.activity_first);
        Timber.tag(TAG).d("onCreate");
        getData();


    }

    private void getData() {
        Intent intent  = getIntent();
        String param1 = intent.getStringExtra("param1");
        String param2 = intent.getStringExtra("param2");
        Timber.tag(TAG).d("param1:"+param1);
        Timber.tag(TAG).d("param2:"+param2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.tag(TAG).d("onDestroy");

    }

    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context,FirstActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello NormalActivity!");
        setResult(RESULT_OK,intent);

    }
}

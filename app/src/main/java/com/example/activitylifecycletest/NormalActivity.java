package com.example.activitylifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import timber.log.Timber;

public class NormalActivity extends BaseActivity {

    public static final String TAG = NormalActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.tag(TAG).d("Task id is " + getTaskId());
        setContentView(R.layout.normal_layout);
        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstActivity.actionStart(NormalActivity.this, "data1", "data2");
            }
        });

        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, FirstActivity.class);
                NormalActivity.this.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Timber.tag(TAG).d("onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                ToastUtils.showLong("You clicked Add");
                break;
            case R.id.remove_item:
                ToastUtils.showLong("You clicked Remove");
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (RESULT_OK==resultCode){
                    String returnData = data.getStringExtra("data_return");
                    Timber.tag(TAG).d("returnData:"+returnData);
                }
                break;
            default:
        }

    }
}

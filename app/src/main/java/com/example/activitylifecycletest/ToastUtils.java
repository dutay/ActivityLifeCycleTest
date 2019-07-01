package com.example.activitylifecycletest;

import android.view.Gravity;
import android.widget.Toast;

import com.example.app.MainApplication;


/**
 * Toast工具类
 *
 */
public class ToastUtils {

    private static Toast mToast;

    public static void showLong(final String text) {
        MainApplication.getHandler().post(new Runnable() {
            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(MainApplication.getApplicationInstance(), text, Toast.LENGTH_LONG);
                } else {
                    mToast.cancel();
                    mToast = Toast.makeText(MainApplication.getApplicationInstance(), text, Toast.LENGTH_LONG);
                }
                mToast.setGravity(Gravity.CENTER, 0, 0);
                mToast.show();
            }
        });
    }

    public static void showShort(final String text) {
        MainApplication.getHandler().post(new Runnable() {
            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(MainApplication.getApplicationInstance(), text, Toast.LENGTH_SHORT);
                } else {
                    mToast.cancel();
                    mToast = Toast.makeText(MainApplication.getApplicationInstance(), text, Toast.LENGTH_SHORT);
                }
                mToast.setGravity(Gravity.CENTER, 0, 0);
                mToast.show();
            }
        });
    }

    /**
     * 该方法多次调用只会显示一次Toast
     * @param text
     */
    public static void showOnlyOneTimeToast(final String text) {
        MainApplication.getHandler().post(new Runnable() {
            @Override
            public void run() {
                try {
                    if (mToast == null) {
                        mToast = Toast.makeText(MainApplication.getApplicationInstance(), text, Toast.LENGTH_SHORT);
                    }
                    mToast.setText(text);
                    mToast.setGravity(Gravity.CENTER, 0, 0);
                    if (!mToast.getView().isShown()){
                        mToast.show();
                    }
                }catch (Exception e){

                }
            }
        });
    }

}

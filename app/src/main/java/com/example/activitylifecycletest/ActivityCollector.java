package com.example.activitylifecycletest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    public List<Activity> activities = new ArrayList<>();

    private static ActivityCollector mActivityCollector;

    private ActivityCollector(){

    }

    public static ActivityCollector getInstance(){
        if (mActivityCollector==null){
            mActivityCollector = new ActivityCollector();
        }
        return mActivityCollector;
    }

    public  void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }





}

package com.xc.brace.frame;

import android.app.Activity;

import com.xc.brace.frame.view.ActivityLifeCycleDelegate;

/**
 * Created by familylove on 2016/7/3.
 */
public interface ActivityLifeCycleDelegateProvider {
    ActivityLifeCycleDelegate createActivityLifeCycleDelegate(Activity activity);
}

package com.xc.brace.frame.beam;

import android.app.Activity;

import com.xc.brace.frame.ActivityLifeCycleDelegateProvider;
import com.xc.brace.frame.beam.expansion.overlay.ViewExpansionDelegate;
import com.xc.brace.frame.beam.expansion.overlay.ViewExpansionDelegateProvider;
import com.xc.brace.frame.view.ActivityLifeCycleDelegate;
import com.xc.brace.frame.view.BaseBeamActivity;

/**
 * Created by familylove on 2016/7/2.
 */
public class Beam {

    private static ViewExpansionDelegateProvider mViewExpansionDelegateProvider ;
    private static ActivityLifeCycleDelegateProvider mActivityLifeCycleDelegateProvider ;


    public static ActivityLifeCycleDelegate createActivityLifeCycleDelegate(Activity activity){
        if (mActivityLifeCycleDelegateProvider!=null){

            return mActivityLifeCycleDelegateProvider.createActivityLifeCycleDelegate(activity) ;
        }else {
            return null;
        }
    }

    public static ViewExpansionDelegate createViewExpansionDelegate(BaseBeamActivity activity){
        if (mViewExpansionDelegateProvider==null){
            return ViewExpansionDelegateProvider.DEFAULT.createViewExpansionDelegate(activity) ;
        }else {
            return mViewExpansionDelegateProvider.createViewExpansionDelegate(activity) ;
        }
    }

    public static void setActivityLifeCycleDelegateProvider(ActivityLifeCycleDelegateProvider activityLifeCycleDelegateProviderClass){
        mActivityLifeCycleDelegateProvider = activityLifeCycleDelegateProviderClass ;

    }

    public static void setViewExpansionDelegateProvider(ViewExpansionDelegateProvider viewExpansionDelegateProviderClass){
        mViewExpansionDelegateProvider = viewExpansionDelegateProviderClass ;

    }



}

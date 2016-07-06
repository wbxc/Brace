package com.xc.brace.frame.beam.expansion.overlay;

import android.view.View;
import android.widget.FrameLayout;

import com.xc.brace.frame.view.BaseBeamActivity;

public abstract class ViewExpansionDelegate {
    private BaseBeamActivity activity;
    private FrameLayout container;

    public ViewExpansionDelegate(BaseBeamActivity activity) {
        this.activity = activity;
       // this.container = activity.getParentView();
    }

    public final BaseBeamActivity getActivity() {
        return activity;
    }

    public final FrameLayout getContainer() {
        return container;
    }

    public void showProgressDialog(String title){}
    public void dismissProgressDialog(){}
    public View showProgressPage(){return  null;}
    public void dismissProgressPage(){}
    public View showErrorPage(){return  null;}
    public void dismissErrorPage(){}
    public void setErrorRetryListener(OnRetryListener listener){}
    public interface OnRetryListener{
        void onRetry();
    }
    public void addCustomOverlayView(View view){}
    public void removeCustomOverlayView(View view){}

}
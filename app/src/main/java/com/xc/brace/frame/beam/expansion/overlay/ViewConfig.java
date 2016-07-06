package com.xc.brace.frame.beam.expansion.overlay;

import android.view.View;

import com.xc.brace.R;

/**
 * Created by familylove on 2016/7/3.
 */
public class ViewConfig implements Cloneable{

    static ViewConfig DEFAULT = new ViewConfig() ;
    String mProgressTitle = "请稍等" ;
    View mProgressView ;
    int mProgressRes  = R.layout.beam_view_progress ;
    int mErrorRes = R.layout.beam_view_error ;
    View mErrorView ;

    public ViewConfig setProgressTitle(String progressTitle){
        this.mProgressTitle = progressTitle ;
        return  this ;
    }
    public ViewConfig setProgressView(View progressView){
        this.mProgressView = progressView ;

        return this ;
    }
    public ViewConfig setProgressRes(int progressRes){
        this.mProgressRes = progressRes ;
        return this ;
    }
    public ViewConfig setErrorRes(int errorRes){
        this.mErrorRes = errorRes ;
        return this ;
    }

    public ViewConfig setErrorView(View errorView){
        this.mErrorView = errorView ;
        return this ;
    }


    @Override
    protected ViewConfig clone() {
        try {
            return (ViewConfig)super.clone() ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new ViewConfig() ;
    }
}

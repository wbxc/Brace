package com.xc.brace.frame.beam.expansion.overlay;

import android.app.ProgressDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xc.brace.R;
import com.xc.brace.frame.view.BaseBeamActivity;

/**
 * Created by familylove on 2016/7/3.
 *
 * 完成
 */
public class DefaultViewExpansionDelegate extends ViewExpansionDelegate {

    private ViewConfig mConfig  ;
    private ProgressDialog mProgressDialog ;
    private OnRetryListener mOnRetryListener ;
    private View mProgressView ;
    private View mErrorView ;


    public DefaultViewExpansionDelegate(BaseBeamActivity activity) {
        super(activity);
        mConfig = new ViewConfig() ;
    }

    public DefaultViewExpansionDelegate(BaseBeamActivity activity ,ViewConfig config){
        super(activity);
        this.mConfig = config ;
    }

    public ViewConfig getConfig(){
        return ViewConfig.DEFAULT.clone() ;
    }
    @Override
    public void showProgressDialog(String title) {
        super.showProgressDialog(title);
        if (mProgressDialog!=null && mProgressDialog.isShowing()) mProgressDialog.dismiss();
        mProgressDialog = new ProgressDialog(getActivity()) ;
        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(mConfig.mProgressTitle);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog!=null){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public View showProgressPage() {
        if (mProgressView==null){
            if (mConfig.mProgressView!=null) mProgressView = mConfig.mProgressView ;
            else mProgressView = getActivity().getLayoutInflater().inflate(mConfig.mProgressRes,getContainer(),false) ;
        }
        if (mProgressView.getParent() == null) getContainer().addView(mProgressView);
        setToolBar(mProgressView);
        return mProgressView ;
    }


    /**
     * mProgressView上设置Toobar
     * @param view
     */
    public void setToolBar(View view){
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar) ;
        if (toolbar!=null){
            getActivity().setSupportActionBar(toolbar);
            getActivity().onSetToolbar(toolbar);
        }
    }
    @Override
    public void dismissProgressPage() {
        super.dismissProgressPage();
        if (mProgressView!=null)
            getContainer().removeView(mProgressView);
    }

    @Override
    public View showErrorPage() {


        if (mErrorView==null){
            if (mConfig.mErrorView!=null) mErrorView = mConfig.mErrorView ;
            else mErrorView = getActivity().getLayoutInflater().inflate(mConfig.mErrorRes,getContainer(),false) ;
        }
        if (mErrorView.getParent()==null)getContainer().addView(mErrorView);
        mErrorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mOnRetryListener!=null)
                    mOnRetryListener.onRetry();
            }
        });
        setToolBar(mErrorView);

        return  mErrorView ;
    }

    @Override
    public void dismissErrorPage() {
        if (mErrorView!=null)
            getContainer().removeView(mErrorView);
    }

    @Override
    public void setErrorRetryListener(OnRetryListener listener) {
        mOnRetryListener = listener ;
    }

    @Override
    public void addCustomOverlayView(View view) {

        getContainer().addView(view);

    }

    @Override
    public void removeCustomOverlayView(View view) {
        getContainer().removeView(view);
    }
}

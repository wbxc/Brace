package com.xc.brace.frame.view;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xc.brace.R;
import com.xc.brace.frame.Presenter;
import com.xc.brace.frame.beam.Beam;
import com.xc.brace.frame.beam.expansion.overlay.ViewExpansionDelegate;

/**
 * Created by familylove on 2016/7/2.
 *
 * 完成
 */
public class BaseBeamActivity <T extends Presenter> extends BeamAppCompatActivity {

    private Toolbar toolbar ;

    private FrameLayout mContent ;
    private FrameLayout mContentParent ;

    @Override
    public void preCreatePresenter() {
        super.preCreatePresenter();
        initViewTree();
    }

    public FrameLayout getParentView(){
        return  mContentParent ;
    }


    private void initViewTree(){
        mContentParent = (FrameLayout)findViewById(android.R.id.content) ;
        mContent = new FrameLayout(this) ;
        super.setContentView(mContent);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        this.setContentView(getLayoutInflater().inflate(layoutResID,mContent,false));
    }

    @Override
    public void setContentView(View view) {
        this.setContentView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContent.addView(view);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar) ;
        if (toolbar!=null)
            onSetToolbar(toolbar);
    }

    public Toolbar getToolbar(){
        return  toolbar ;
    }
    public void  onSetToolbar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home){
            finish();
            return false ;
        }
        return super.onOptionsItemSelected(item);
    }

    private ViewExpansionDelegate mDelegate ;
    public ViewExpansionDelegate createViewExpansionDelegate(){
        return Beam.createViewExpansionDelegate(this) ;
    }

    public final  ViewExpansionDelegate getExpansion(){
        if (mDelegate==null) mDelegate = createViewExpansionDelegate() ;
        return mDelegate ;
    }

    protected  final <E extends View> E $(@NonNull View view, @IdRes int id){
        return (E)view.findViewById(id) ;
    }

    protected final <E extends View> E viewId(@NonNull View view , @IdRes int id){
        return (E)view.findViewById(id) ;
    }
    protected final <E extends View> E $(@IdRes int id){
        return (E)findViewById(id) ;
    }

    protected final <E extends View> E viewId(@IdRes int id){
        return (E)findViewById(id) ;
    }

}

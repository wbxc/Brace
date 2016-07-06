package com.xc.brace.frame.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xc.brace.frame.Presenter;
import com.xc.brace.frame.ViewHelper;

/**
 * Created by familylove on 2016/7/2.
 *
 * 基础Fragment 完成
 */
public class BeamFragment<PresenterType extends Presenter> extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        helper.postCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        helper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        helper.onSave(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        helper.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        helper.onPause();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        helper.onResult(requestCode,resultCode,data);
    }

    public PresenterType getPresenter(){
        return  helper.getPresenter() ;
    }

    public ViewHelper<PresenterType> helper = new ViewHelper<>(this) ;

    protected final <E extends View> E $(@NonNull View view, @IdRes int id){
        return (E)view.findViewById(id) ;
    }

    protected final <E extends View>E viewId(@NonNull View view , @IdRes int id){
        return (E)view.findViewById(id) ;
    }
}

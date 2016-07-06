package com.xc.brace.frame;

import android.content.Intent;
import android.os.Bundle;

import com.xc.brace.frame.view.BeamAppCompatActivity;
import com.xc.brace.frame.view.BeamFragment;

/**
 * Created by familylove on 2016/7/2.
 *
 * ViewHelper 控制Presenter 的生命周期
 */
public class ViewHelper <PresenterType extends Presenter >{
    private static final String PRESENTER_ID = "presenter_id" ;
    boolean hasPresenter ;
    PresenterType presenter ;
    Object view ;

    public PresenterType  getPresenter(){
        return presenter ;
    }

    public ViewHelper(Object view) {
        this.view = view;
    }

    public void onCreate(Bundle savedInstanceState){

        String id ;
        if (savedInstanceState == null || (id = savedInstanceState.getString(PRESENTER_ID))==null){
            createPresenter(savedInstanceState);
        }else {
            presenter = PresenterManager.getInstance().get(id) ;
            if (presenter==null)
                createPresenter(savedInstanceState);
        }
    }

    boolean ensurePresenterInstance(){
        if (presenter == null){

            if (hasPresenter){
                if (view instanceof BeamAppCompatActivity){
                    ((BeamAppCompatActivity) view).recreate();
                }else if (view instanceof BeamFragment){
                    ((BeamFragment)view).getActivity().recreate();
                }
            }
            return false ;
        }else {
            return  true ;
        }
    }

    private void createPresenter(Bundle saveInstanceState){
        presenter = PresenterManager.getInstance().create(view) ;
        hasPresenter = presenter!=null;
        if (hasPresenter)
            presenter.onCreate(view,saveInstanceState);
    }

    public void postCreate(){
        if (ensurePresenterInstance())
            presenter.onCreateView(view);
    }
    public void onDestroyView(){
        if (ensurePresenterInstance())
            presenter.onDestroyView();
    }
    public void onDestroy(){
        if (ensurePresenterInstance()){
            presenter.onDestroy();
            PresenterManager.getInstance().destroy(presenter.id);
        }
    }

    public void onSave(Bundle state){
        if (ensurePresenterInstance())
            presenter.onSave(state);
    }

    public void onResume(){
        if (ensurePresenterInstance())
            presenter.onResume();
    }

    public void onPause(){
        if (ensurePresenterInstance())
            presenter.onPause();
    }
    public void onResult(int requestCode , int resultCode , Intent data){
        if (ensurePresenterInstance())
            presenter.onResult(requestCode,resultCode,data);
    }

}

package com.xc.brace.frame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by familylove on 2016/7/2.
 * 基础类
 */
public class Presenter<ViewType> {
    ViewType view ;
    String id ;


    protected void onCreate(@NonNull ViewType view , Bundle savedState){

    }
    protected void onDestroy(){

    } ;
    protected void onCreateView(@NonNull ViewType view){
        this.view = view ;
    }
    protected void onDestroyView(){

    }

    protected void onResume(){

    }

    protected void onPause(){

    }

    protected void onResult(int requestCode , int resultCode , Intent data){

    }

    protected void onSave(Bundle state){

    }
    private void create(@NonNull ViewType view , Bundle state){

        this.view = view ;
        onCreate(view,state);
    }
}

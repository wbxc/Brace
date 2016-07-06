package com.xc.brace.frame;

/**
 * Created by familylove on 2016/7/2.
 */
public abstract class PresenterManager {


    private static PresenterManager instance = new DefaultPresenterManger() ;

    public static PresenterManager getInstance(){
        return instance ;
    }
    public abstract <T extends Presenter> T create(Object view) ;

    public abstract <T extends Presenter> T get(String id) ;

    public abstract void destroy(String id) ;
}

package com.xc.brace.frame;

import java.util.HashMap;

/**
 * Created by familylove on 2016/7/2.
 */
public class DefaultPresenterManger extends PresenterManager {

    private HashMap<String,Presenter> idToPresenter = new HashMap<>() ;
    private int nextId ;


    @Override
    public <T extends Presenter> T create(Object view) {
        T presenter  = PresenterBuilder.fromViewClass(view.getClass()) ;
        if (presenter==null) return null;
        presenter.id =   providePresenter() ;
        idToPresenter.put(presenter.id,presenter) ;
        return presenter;
    }

    @Override
    public <T extends Presenter> T get(String id) {
        return (T)idToPresenter.get(id);
    }

    @Override
    public void destroy(String id) {

        idToPresenter.remove(id) ;
    }

    private String providePresenter(){
        return nextId++ +"/"+System.nanoTime()+"/"+(int)(Math.random()*Integer.MAX_VALUE) ;
    }
}

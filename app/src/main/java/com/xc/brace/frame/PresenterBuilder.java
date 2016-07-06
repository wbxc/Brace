package com.xc.brace.frame;

/**
 * Created by familylove on 2016/7/2.
 */
public class PresenterBuilder {


    public static <PresenterType extends Presenter>PresenterType  fromViewClass(Class<?> viewClass){
        RequiresPresenter  annotation = viewClass.getAnnotation(RequiresPresenter.class) ;
        if (annotation==null){
            return  null;
        }
        Class<PresenterType> presenterTypeClass = (Class<PresenterType>)annotation.value() ;
        PresenterType presenter ;
        try {
            presenter = presenterTypeClass.newInstance() ;
        }catch (InstantiationException e){
            throw new RuntimeException(e) ;
        }catch (IllegalAccessException e){
            throw  new RuntimeException(e) ;
        }
        return presenter ;
    }
}

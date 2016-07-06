package com.xc.brace.frame;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by familylove on 2016/7/2.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPresenter {

    Class<? extends Presenter> value() ;
}

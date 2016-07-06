package com.xc.brace.frame.beam.expansion.overlay;

import com.xc.brace.frame.view.BaseBeamActivity;

/**
 * Created by familylove on 2016/7/2.
 */
public interface ViewExpansionDelegateProvider {

    //ViewExpansionDelegateProvider
    ViewExpansionDelegate createViewExpansionDelegate(BaseBeamActivity baseBeamActivity) ;


    ViewExpansionDelegateProvider DEFAULT = new ViewExpansionDelegateProvider(){
        @Override
        public ViewExpansionDelegate createViewExpansionDelegate(BaseBeamActivity baseBeamActivity) {
            return null;
        }
    } ;

}

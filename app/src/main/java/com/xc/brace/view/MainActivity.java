package com.xc.brace.view;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.xc.brace.R;
import com.xc.brace.model.Person;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.datatype.BmobTableSchema;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.GetAllTableSchemaListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    private Fragment fragContent ;
    private FragmentTabHost fragmentTabHost ;
    private int arrayDraw[] = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher} ;
    private Class arrayCass[] = {FirstFragment.class,SecondFragment.class,ThreeFragment.class} ;
    private String textString[] ={"第一","第二","第三"} ;

    private List<View> mViews = new ArrayList<View>() ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost) ;
        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.content);

        for (int i=0 ; i<3 ; i++){
            View view = getTabItemView(i) ;
            mViews.add(view) ;
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(String.valueOf(i)).setIndicator(view) ;
            fragmentTabHost.addTab(tabSpec,arrayCass[i],null);
        }

        fragmentTabHost.getTabWidget().setDividerDrawable(R.color.colorTransparent);
        fragmentTabHost.setCurrentTab(0);
        
    }

    private View getTabItemView(int index){

        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_item_view,null) ;
        TextView textView = (TextView)view.findViewById(R.id.textview) ;
        Drawable rightDrawable = getResources().getDrawable(R.drawable.first_tab_drawable);
        rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
        textView.setCompoundDrawables(null, rightDrawable, null, null);
        textView.setText(textString[index]);
        return view ;
    }
}

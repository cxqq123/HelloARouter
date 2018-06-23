package com.cx.basemodule;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by cx on 2018/6/22.
 */

public abstract class BaseActivity extends AppCompatActivity{

    protected Toolbar mToolbar;
    protected TextView mTitle;
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        initToolbar();
        initView();
    }

    protected abstract int getLayoutId();
    protected abstract void initView();

    protected void initToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = findViewById(R.id.tv_title);

        if(null != mToolbar){
            if(mToolbar.getVisibility() == View.GONE){
                mToolbar.setVisibility(View.VISIBLE);
                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
                    mToolbar.setNavigationIcon(R.drawable.arrow_back);
                    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onLeftClick();
                        }
                    });
                }

            }
        }
    }

    //点击事件
    protected void onLeftClick(){
        finish();
    }

    //设置标题
    protected void setTitle(String title){
        if(mTitle != null){
            mTitle.setText(title);
        }
    }

}

package com.cx.helloarouter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    private TextView tvApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initARouter();
        tvApp = findViewById(R.id.tv_app);
        tvApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                module1();
            }
        });

    }

    public void initARouter(){
        ARouter.init(getApplication());
        ARouter.openLog();
        ARouter.openDebug();
    }

    public void module1(){
        ARouter.getInstance()
                .build("/modulelib1/main")
                .withString("data" , "app传过来的内容")
                .navigation();
    }
}

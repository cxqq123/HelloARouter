package com.cx.modulelib1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/modulelib1/main")
public class Modulelib1_MainActivity extends AppCompatActivity {

    private TextView tvModule1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_modulelib1);
        String data = getIntent().getStringExtra("data");
        Toast.makeText(this , "传递的参数:" + data , Toast.LENGTH_LONG).show();
        tvModule1 = findViewById(R.id.tv_module1);
        tvModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                module2();
            }
        });
    }

    public void module2(){
        ARouter.getInstance()
                .build("/modulelib2/main")
                .navigation();
    }
}

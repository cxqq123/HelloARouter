package com.cx.mainmodule.debug;

import com.cx.basemodule.BaseActivity;
import com.cx.mainmodule.R;

public class DebugMainActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_debug_main;
    }

    @Override
    protected void initView() {
        setTitle("主界面");
    }
}

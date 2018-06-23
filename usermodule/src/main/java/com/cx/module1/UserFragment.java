package com.cx.module1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cx.basemodule.BaseFragment;
import com.cx.routermodule.RouterTable;

/**
 * Created by cx on 2018/6/23.
 */

@Route(path = "/user/userFragment")
public class UserFragment extends BaseFragment {

    private TextView tvModule;
    private Button btnButton;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected View initView(View parent) {
        tvModule = parent.findViewById(R.id.tv_module);
        btnButton = parent.findViewById(R.id.btn_jump);
        tvModule.setText("我的\nUserModule");
        btnButton.setText("跳转首页界面");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ReflectUtils.startActivityWithName(mContext, "com.wustor.goodsmodule.GoodsDetailActivity");
                ARouter.getInstance().build(RouterTable.Main_MainActivity).navigation();
            }
        });
        return parent;
    }
}

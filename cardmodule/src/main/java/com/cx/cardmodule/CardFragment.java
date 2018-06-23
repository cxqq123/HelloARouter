package com.cx.cardmodule;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cx.basemodule.BaseFragment;
import com.cx.routermodule.RouterTable;

/**
 * Created by cx on 2018/6/22.
 */

@Route(path = "/card/cardFragment")
public class CardFragment extends BaseFragment{

    private TextView tvModule;
    private Button btnButton;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cart;
    }

    @Override
    protected View initView(View parent) {
        tvModule = parent.findViewById(R.id.tv_module);
        btnButton = parent.findViewById(R.id.btn_jump);
        tvModule.setText("卡片\nCartModule");
        btnButton.setText("跳转到我的详情");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ReflectUtils.startActivityWithName(mContext, "com.wustor.goodsmodule.GoodsDetailActivity");
                ARouter.getInstance().build(RouterTable.User_UserActivity).navigation();
            }
        });
        return parent;
    }
}

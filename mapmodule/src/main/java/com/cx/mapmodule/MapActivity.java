package com.cx.mapmodule;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cx.basemodule.BaseActivity;

@Route(path = "/map/MapActivity")
public class MapActivity extends BaseActivity {

    private TextView tvModule;
    private Button btnButton;
    private Button btnCall;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_map;
    }

    @Override
    protected void initView() {
        setTitle("商品详情");
        tvModule = findViewById(R.id.tv_module);
        btnButton = findViewById(R.id.btn_jump);
        tvModule.setText("GoodsModule");
        btnButton.setText("跳转到购物车");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnCall = findViewById(R.id.btn_call);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                CartModuleService moduleCall = (CartModuleService) ReflectUtils.getModuleCall("com.wustor.cartmodule.CartServiceImpl");
//                if (moduleCall != null) {
//                    moduleCall.initContext(mContext);
//                    moduleCall.getCartAmount();
//                } else{
//                    CommonUtils.showToast(mContext, "业务组件单独调试不应该跟其他业务Module产生交互，如果你依然想要在运行期依赖其它组件，那么请参考MainModule");
//                }
            }
        });
    }
}

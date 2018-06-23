package com.cx.mainmodule;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cx.basemodule.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    RadioButton bottomHome;
    RadioGroup radioGroup;

    private List<Fragment> list = new ArrayList<>();
    private Fragment fragmentMain;
    private Fragment fragmentHome;
    private Fragment fragmentCard;
    private Fragment fragmentUser;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        bottomHome = findViewById(R.id.bottom_home);
        radioGroup = findViewById(R.id.radioGroup);

        fragmentMain = getFragment("/main/mainFragment");
        fragmentHome = getFragment("/map/homeFragment");
        fragmentCard = getFragment("/card/cardFragment");
        fragmentUser = getFragment("/user/userFragment");
        if (fragmentMain == null || fragmentHome == null || fragmentCard == null || fragmentUser == null) {
            Log.e("cx" , TAG + "is null");
        } else {
            list.add(fragmentMain);
            list.add(fragmentHome);
            list.add(fragmentCard);
            list.add(fragmentUser);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            beginTransaction.add(R.id.main, fragmentMain);
            beginTransaction.add(R.id.main, fragmentHome);
            beginTransaction.add(R.id.main, fragmentCard);
            beginTransaction.add(R.id.main, fragmentUser);
            beginTransaction.commit();
            showHome();
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bottom_home:
                        changeFragment(1);
                        break;
                    case R.id.bottom_sort:
                        changeFragment(2);
                        break;
                    case R.id.bottom_cart:
                        changeFragment(3);
                        break;
                    case R.id.bottom_user:
                        changeFragment(4);
                        break;
                }
            }
        });
    }

    public void showHome() {
        bottomHome.setChecked(true);
        changeFragment(1);
    }

    public Fragment getFragment(String path){
        Fragment fragment = (Fragment) ARouter.getInstance().build(path).navigation();
        return fragment;
    }

    public void changeFragment(int index) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 != index) {
                // 隐藏选项卡
                fragmentTransaction.hide(list.get(i));
            } else {
                // 显示选项卡
                fragmentTransaction.show(list.get(i));

            }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

}

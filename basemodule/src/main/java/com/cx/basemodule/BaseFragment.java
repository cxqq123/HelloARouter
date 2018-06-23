package com.cx.basemodule;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cx on 2018/6/22.
 */

public abstract class BaseFragment extends Fragment{

    protected Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        ViewGroup view = (ViewGroup) inflater.inflate(getLayoutId() , container , false);
        return initView(view);
    }

    protected abstract int getLayoutId();

    protected abstract View initView(View parent);

}

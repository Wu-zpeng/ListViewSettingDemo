package com.kss.listviewsettingdemo;


import android.view.LayoutInflater;
import android.view.View;

/**
 * 门禁设置界面
 *
 */
public class AccessSettingFragment extends BaseFragment {

    private static final String TAG = AccessSettingFragment.class.getSimpleName();  //得到AccessSettingFragment


    @Override
    protected View initView() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_access_setting, null);

        return view;
    }
}

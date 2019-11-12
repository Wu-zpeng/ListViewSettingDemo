package com.kss.listviewsettingdemo;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 系统设置界面
 */
public class SysSettingFragment extends BaseFragment {
    @Override
    protected View initView() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_sys_setting, null);

        return view;
    }
}

package com.kss.listviewsettingdemo;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 设备自检界面
 */
public class DeviceMyselfFragment extends BaseFragment {
    @Override
    protected View initView() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_device_myself, null);

        return view;
    }
}

package com.kss.listviewsettingdemo;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;


/**
 *  概览信息界面
 */
public class InfoFragment extends BaseFragment {


    private static final String TAG = InfoFragment.class.getSimpleName();  //得到InfoFragment

    @Override
    protected View initView() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_device_info, null);

        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG,"InfoFragment数据初始化");
    }
}

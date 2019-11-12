package com.kss.listviewsettingdemo;

import android.view.LayoutInflater;
import android.view.View;


/**
 * 人脸演示界面
 *
 */
public class FacedemoFragment extends BaseFragment {


    @Override
    protected View initView() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_face_demo, null);

        return view;
    }
}

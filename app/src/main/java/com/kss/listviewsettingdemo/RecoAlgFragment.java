package com.kss.listviewsettingdemo;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;


/**
 * 识别算法界面
 */
public class RecoAlgFragment extends BaseFragment {
    @Override
    protected View initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_reco_alg, null);
        return view;
    }
}

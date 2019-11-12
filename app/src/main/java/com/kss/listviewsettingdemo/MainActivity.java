package com.kss.listviewsettingdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 *  author:Wu_zpeng
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvSetting;

    private List<BaseFragment> mBaseFragment;

    /**
     * 选中fragment对应的位置
     */
    private int FragmentPosition = 0;

    /**
     * 上次切换的fragment
     */
    private Fragment mContent;

    private String[] strs = {"概览信息", "人脸演示", "系统设置", "门禁设置", "识别算法", "设备自检"};

    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化View
        initView();

        //初始化fragment
        initFragment();

        //设置listview适配器
        initAdapter();
    }

    private void initAdapter(){

        myAdapter = new MyAdapter(strs, getBaseContext());

        lvSetting.setAdapter(myAdapter);

        myAdapter.setDefSelect(0);//设置默认选中第一项

        BaseFragment to = getFragment();
        //替换到Fragment
        switchFrament(mContent,to);

        lvSetting.setOnItemClickListener(this);
    }


    /**
     *
     * @param from  刚显示的fragment，马上就要被隐藏了
     * @param to    马上要切换到的fragment，一会要显示
     */
    private void switchFrament(Fragment from, Fragment to){
        if (from != to){    //切换
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();    //开始事务
            //判断to有没有被添加
            if ( !to.isAdded()){    //to没有被添加
                //1.from隐藏
                if (from != null){
                    ft.hide(from);
                }
                //2.添加to
                if (to != null){
                    ft.add(R.id.mFrame, to).commit();
                }
            }else { //to已经被添加
                //1.from隐藏
                if (from != null){
                    ft.hide(from);
                }
                //2.显示to
                if (to != null){
                    ft.show(to).commit();
                }
            }
        }
    }


    /**
     * 根据位置得到对应的fragment
     * @return
     */
    private BaseFragment getFragment(){
        BaseFragment fragment = mBaseFragment.get(FragmentPosition);
        return fragment;
    }

    private void initFragment(){
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new InfoFragment());  //概览信息fragment
        mBaseFragment.add(new FacedemoFragment());  //人脸演示fragment
        mBaseFragment.add(new SysSettingFragment());  //系统设置fragment
        mBaseFragment.add(new AccessSettingFragment());  //门禁设置fragment
        mBaseFragment.add(new RecoAlgFragment());       //识别算法fragment
        mBaseFragment.add(new DeviceMyselfFragment());  //设备自检fragment

    }

    private void initView(){
        lvSetting = findViewById(R.id.lv_setting_items);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        myAdapter.setDefSelect(position);//更改选中项

        FragmentPosition = position; //当默认为第一条时，设置默认Position = 0 即可

        //根据位置得到对应的Fragment
        BaseFragment to = getFragment();
        //替换到Fragment
        switchFrament(mContent,to);
    }
}

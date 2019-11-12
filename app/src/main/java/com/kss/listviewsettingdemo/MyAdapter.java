package com.kss.listviewsettingdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private String[] mData;

    private int defItem;    //声明默认选中的项

    /**
     * 适配器中添加这个方法
     * 默认选中项
     * @param position
     */
    public void setDefSelect(int position) {
        this.defItem = position;
        notifyDataSetChanged();
    }

    public MyAdapter(String[] mData, Context context) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_face_setting_item,null);
            holder.mListViewText = convertView.findViewById(R.id.mListViewText);
            holder.llBg = convertView.findViewById(R.id.ll_bg);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        String name = mData[position];
        holder.mListViewText.setText(name);


        //true和false用来解决复用问题的，如果当前标记为选中状态那么item字体颜色变红，红色竖条显示，item背景色变白
        if (defItem == position){

            holder.mListViewText.setTextColor(Color.WHITE);
            holder.llBg.setBackgroundColor(Color.BLUE);


        } else {//如果不是被选中的状态，item字体颜色变黑，红色竖条隐藏，item背景还变灰
            holder.mListViewText.setTextColor(Color.BLACK);
            holder.llBg.setBackgroundColor(Color.parseColor("#EBEBEB"));
        }

        return convertView;
    }

    class ViewHolder{
        public TextView mListViewText;
        public LinearLayout llBg;
    }
}

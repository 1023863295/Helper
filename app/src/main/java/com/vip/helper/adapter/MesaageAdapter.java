package com.vip.helper.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.vip.helper.bean.MessageBean;

import java.util.List;

/**
 * Created by liuliang on 2017/7/6.
 */

public class MesaageAdapter extends RecyclerView.Adapter{
    private List<MessageBean> mList;


    public void setmList(List<MessageBean> mList) {
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

package com.vip.helper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by liuliang on 2017/8/15.
 */

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyHolder>{
    private OnItemClickLitener onItemClickLitener;
    private Context mContext;
    private List<Object> dataList;

    public MyOrderAdapter(Context mContext, List<Object> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        this.onItemClickLitener = onItemClickLitener;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }



    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    public MyOrderAdapter() {
        super();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}

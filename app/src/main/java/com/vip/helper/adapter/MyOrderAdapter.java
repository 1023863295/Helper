package com.vip.helper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;

import java.util.List;

/**
 * Created by liuliang on 2017/8/15.
 */

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyHolder> implements View.OnClickListener{
    private OnItemClickLitener onItemClickLitener;
    private Context mContext;
    private List<Object> dataList;
    View root;

    public MyOrderAdapter() {
        super();
    }

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
        root = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main_order_item, parent, false);
        MyHolder vh = new MyHolder(root);
        vh.rootView.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private View rootView;
        private ImageView img;
        private TextView textName1;
        private TextView textName2;

        public MyHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            img = (ImageView) root.findViewById(R.id.order_item_img);
        }
    }

    @Override
    public void onClick(View v) {
//        onItemClickLitener.onItemClick(v);
    }
}

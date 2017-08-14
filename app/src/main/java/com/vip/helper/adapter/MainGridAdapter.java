package com.vip.helper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vip.helper.R;

import java.util.List;

/**
 * 作者：liuliang
 * 时间 2017/8/13 19:33
 * 邮箱：liang.liu@zmind.cn
 */
public class MainGridAdapter extends RecyclerView.Adapter<MainGridAdapter.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private Context mContext;
    private List<Integer> datas;//数据
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    View root;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    //自定义监听事件
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view);
        void onItemLongClick(View view);
    }

    //适配器初始化
    public MainGridAdapter(Context context,List<Integer> datas) {
        mContext=context;
        this.datas=datas;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        root = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main_grid_item, parent, false);
        ViewHolder vh = new ViewHolder(root);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textName.setText("name");
        holder.textName.setBackgroundResource(R.drawable.tab_icon_1);
        holder.rootView.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onClick(View v) {
        mOnItemClickListener.onItemClick(v);

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    //视图管理
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textName;
        private View rootView;

        public ViewHolder(View root) {
            super(root);
            rootView = root;
            textName = (TextView) root.findViewById(R.id.main_grid_item_text_name);
        }
    }

}

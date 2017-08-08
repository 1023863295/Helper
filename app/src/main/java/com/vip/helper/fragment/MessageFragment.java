package com.vip.helper.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vip.helper.R;
import com.vip.helper.adapter.MesaageAdapter;
import com.vip.helper.bean.MessageBean;
import com.vip.helper.view.StateLayoutView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：liuliang
 * 时间 2017/7/4 23:07
 * 邮箱：liang.liu@zmind.cn
 * 消息頁面
 */
public class MessageFragment extends Fragment{
    private View view;
    private RecyclerView  recyclerView;
    private List<MessageBean> mlist;
    private MesaageAdapter mesaageAdapter;

    protected Activity mActivity;
    protected StateLayoutView stateLayoutView;

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity)context;
    }

    public Activity getmActivity() {
        return mActivity;
    }

    //防止Fragment重复加载
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (stateLayoutView == null){
            // 说明这个Fragemnt的onCreateView方法是第一次执行
            view = inflater.inflate(R.layout.fragment_message, container, false);
            stateLayoutView = stateLayoutView.newInstance(mActivity, view);
            initView();
        }else{
            ViewGroup parent = (ViewGroup) stateLayoutView.getParent();
            if (parent != null) {
                parent.removeView(stateLayoutView);
            }
        }
        return stateLayoutView;
    }

    private void initView(){
        initDate();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_view);
        recyclerView.setLayoutManager(layoutManager);
        mesaageAdapter = new MesaageAdapter();
        mesaageAdapter.setmList(mlist);
        recyclerView.setAdapter(mesaageAdapter);
        stateLayoutView.showFailView();
    }

    private void initDate(){
        mlist = new ArrayList<>();
    }

}

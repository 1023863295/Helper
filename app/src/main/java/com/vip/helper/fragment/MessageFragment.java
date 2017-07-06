package com.vip.helper.fragment;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_message, container, false);
        initView();
        return view;
    }

    private void initView(){
        initDate();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_view);
        recyclerView.setLayoutManager(layoutManager);
        mesaageAdapter = new MesaageAdapter();
        mesaageAdapter.setmList(mlist);
        recyclerView.setAdapter(mesaageAdapter);
    }

    private void initDate(){
        mlist = new ArrayList<>();
    }

}

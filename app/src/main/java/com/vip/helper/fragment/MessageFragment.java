package com.vip.helper.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vip.helper.R;

/**
 * 作者：liuliang
 * 时间 2017/7/4 23:07
 * 邮箱：liang.liu@zmind.cn
 * 消息頁面
 */
public class MessageFragment extends Fragment{
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_message, container, false);
        return view;
    }
}

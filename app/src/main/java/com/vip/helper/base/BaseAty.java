package com.vip.helper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vip.helper.view.StateLayoutView;

/**
 * 作者：liuliang
 * 时间 2017/7/3 21:52
 * 邮箱：liang.liu@zmind.cn
 */
public abstract class BaseAty extends AppCompatActivity {
    public StateLayoutView stateLayoutView;
    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        view = View.inflate(this,getLayoutView(),null);
        stateLayoutView = StateLayoutView.newInstance(this,view);
        setContentView(stateLayoutView);
        stateLayoutView.showContentView();

        initView();
        afterViewInit();
    }

    /**
     * 初始化数据，包括从bundle中获取数据保存到当前activity中
     */
    protected abstract void initData();


    /**
     * 设置viewlayout
     */
    protected abstract int getLayoutView();

    /**
     * 初始化界面，如获取界面中View的名称并保存，定义Title的文字，以及定义各个控件的处理事件
     */
    protected abstract void initView();

    /**
     * 界面初始化之后的后处理，如启动网络读取数据、启动定位等
     */
    protected abstract void afterViewInit();

}

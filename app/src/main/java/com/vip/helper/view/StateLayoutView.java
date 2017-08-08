package com.vip.helper.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.vip.helper.R;

/**
 * Created by liuliang on 2017/8/8.
 * 状态布局，封装了4种状态：正在加载、加载失败、加载为空、正常界面
 * 使用{@link (Context, View)} 来创建StateLayout的实现
 */

public class StateLayoutView extends FrameLayout {
    private View loadingView;
    private View failView;
    private View emptyView;
    private View contentView;
    private boolean isShow;


    public StateLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 创建一个StateLayout实现
     * @param contentView 正常想要展示的View
     */
    public static StateLayoutView newInstance(Context context, View contentView) {
        StateLayoutView stateLayout = (StateLayoutView) LayoutInflater.from(context).inflate(R.layout.state_layout, null);
        stateLayout.contentView=contentView;
        // StateLayout inflate之后就有3个状态的View了，还需要第四种状态
        stateLayout.addView(contentView);
        //当添加完成后暂时给隐藏掉
        contentView.setVisibility(View.GONE);
        return stateLayout;
    }

    /**
     * 渲染完毕后展示获取view对象
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        loadingView = findViewById(R.id.loadingView);
        failView = findViewById(R.id.failView);
        emptyView = findViewById(R.id.emptyView);

        failView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                reLoad();
            }
        });

        showLoadingView();
    }

    /** 显示正在加载的View */
    public void showLoadingView() {
        showView(loadingView);
    }

    /** 显示失败的View */
    public void showFailView() {
        showView(failView);
    }

    /** 显示加载为空的View */
    public void showEmptyView() {
        showView(emptyView);
    }

    /** 显示正常界面的View */
    public void showContentView() {
        showView(contentView);
    }

    /**
     * 显示指定的View，并且隐藏其它的View
     * @param view 指定要显示的View
     */
    private void showView(View view) {
        for (int i = 0; i <getChildCount(); i++) {
            View child = getChildAt(i);	//
            child.setVisibility(view == child ? View.VISIBLE : View.GONE);
        }
    }

    /*重新加载*/
    public void reLoad(){
        if (reloadListener != null){
            reloadListener.reLoad();
        }
    }
    private ReloadListener reloadListener;
    public  interface  ReloadListener{
       public void reLoad();
    }

    public void setReloadListener(ReloadListener reloadListener) {
        this.reloadListener = reloadListener;
    }
}

package com.vip.helper.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;

/**
 * Created by liuliang on 2017/8/15.
 */

public class OrderListAty extends BaseAty implements View.OnClickListener{

    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private int type;

    private RecyclerView recyclerView;

    @Override
    protected void initData() {
        type = getIntent().getIntExtra("type",0);
    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_order_layout;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setOnClickListener(this);

        textRight = (TextView)findViewById(R.id.top_title_right_more);
        textRight.setOnClickListener(this);
        textRight.setText("+");
        textRight.setTextSize(30);
        textRight.setVisibility(View.VISIBLE);

        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        switch (type){
            case 0:
                textTitle.setText("我的求购");
                break;
            case 1:
                textTitle.setText("我的代购");
                break;
            case 2:
                textTitle.setText("我的收藏");
                break;
        }

        recyclerView = (RecyclerView)findViewById(R.id.order_list_recycle_view);
    }

    @Override
    protected void afterViewInit() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_title_img_back:
                finish();
                break;
            case R.id.top_title_right_more:
                break;
        }

    }
}

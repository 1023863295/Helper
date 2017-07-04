package com.vip.helper.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;

/**
 * 作者：liuliang
 * 时间 2017/7/4 22:50
 * 邮箱：liang.liu@zmind.cn
 * 我的求购
 */
public class MyWantToBuyAty extends BaseAty implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;


    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_my_want_to_buy_layout;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        textTitle.setText("我的求购");
        textRight = (TextView)findViewById(R.id.top_title_right_more);
        textRight.setVisibility(View.VISIBLE);
        textRight.setText("+");
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

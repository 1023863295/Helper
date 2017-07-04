package com.vip.helper.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;

/**
 * 作者：liuliang
 * 时间 2017/7/4 22:53
 * 邮箱：liang.liu@zmind.cn
 * 订单详情
 */
public class OrderDetailAty extends BaseAty implements View.OnClickListener {
    private ImageView imgBack;
    private TextView textTitle;

    private Button btnPay;

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_order_detail_layout;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        textTitle.setText("订单详情");

        btnPay = (Button) findViewById(R.id.order_detail_btn_pay);
        btnPay.setOnClickListener(this);
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
            case R.id.order_detail_btn_pay:
                Intent intent = new Intent(this,PayMethodsAty.class);
                startActivity(intent);
                break;
        }
    }
}

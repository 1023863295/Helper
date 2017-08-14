package com.vip.helper.ui;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;
import com.vip.helper.utils.WebConfig;

/**
 * Created by liuliang on 2017/8/14.
 */

public class WebAty extends BaseAty implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;

    private WebView mWebView;

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_web_layout;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        textTitle.setText("Title");

        mWebView = (WebView)findViewById(R.id.web_webview);
        WebConfig.setDefaultConfig(mWebView,this);
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
        }

    }
}

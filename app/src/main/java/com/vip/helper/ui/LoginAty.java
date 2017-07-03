package com.vip.helper.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;

/**
 * 作者：liuliang
 * 时间 2017/7/3 22:13
 * 邮箱：liang.liu@zmind.cn
 */
public class LoginAty extends BaseAty implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button btnLogin;
    private TextView textRegister;
    private TextView textForgot;

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_login_layout;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        textTitle.setText("登录");

        editTextUsername = (EditText)findViewById(R.id.login_edit_username);
        editTextPassword = (EditText)findViewById(R.id.login_edit_password);
        btnLogin = (Button)findViewById(R.id.login_btn_login);
        btnLogin.setOnClickListener(this);
        textRegister = (TextView)findViewById(R.id.login_text_register);
        textRegister.setOnClickListener(this);
        textForgot = (TextView)findViewById(R.id.login_text_forgot);
        textForgot.setOnClickListener(this);
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
            case R.id.login_btn_login:
                break;
            case R.id.login_text_register:
                Intent intentRegister = new Intent(this,RegisterAty.class);
                startActivity(intentRegister);
                break;
            case R.id.login_text_forgot:
                Intent intentFindBack = new Intent(this,FindBackAty.class);
                startActivity(intentFindBack);
                break;
        }

    }
}

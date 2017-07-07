package com.vip.helper.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;
import com.vip.helper.tool.StringUtil;
import com.vip.helper.tool.ToastUtil;

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

    private String strUsername;
    private String strPassword;

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
                login();
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

    private boolean check(){
        strUsername = editTextUsername.getText().toString();
        strPassword = editTextPassword.getText().toString();
        if (StringUtil.isEmpty(strUsername)){
            ToastUtil.showShortToast(this,"用户名不能为空");
            return  false;
        }else if(!StringUtil.isPhone(strUsername)){
            ToastUtil.showShortToast(this,"请输入正确手机号");
            return  false;
        }else if(StringUtil.isEmpty(strPassword)){
            ToastUtil.showShortToast(this,"密码不能为空");
            return  false;
        }else if(strPassword.length()< 6){
            ToastUtil.showShortToast(this,"密码输入有误");
            return  false;
        }
        return  true;
    }

    //登录
    private void login(){
        if(check()){

        }
    }
}

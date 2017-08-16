package com.vip.helper.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.vip.helper.R;
import com.vip.helper.base.BaseAty;
import com.vip.helper.bean.CommonResult;
import com.vip.helper.bean.VipUserBean;
import com.vip.helper.global.Constants;
import com.vip.helper.status.MultipleStatusView;
import com.vip.helper.tool.GsonUtils;
import com.vip.helper.tool.OkhttpUtil;
import com.vip.helper.tool.SharedPreferencesHelper;
import com.vip.helper.tool.StringUtil;
import com.vip.helper.tool.ToastUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者：liuliang
 * 时间 2017/7/3 22:13
 * 邮箱：liang.liu@zmind.cn
 */
public class LoginAty extends BaseAty implements View.OnClickListener{

    private ImageView imgBack;
    private TextView textTitle;

    private MultipleStatusView mMultipleStatusView;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button btnLogin;

    private String strUsername;
    private String strPassword;

    private TextView textRegister;
    private TextView textForgot;


    public static final int LOGIN_SUCCESS = 10;
    public static final int LOGIN_FAILD = 20;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case LOGIN_FAILD:
//                    mMultipleStatusView.showError();
                    ToastUtil.showShortToast(LoginAty.this,"请稍后重试");
                    break;
                case LOGIN_SUCCESS:
//                    mMultipleStatusView.showContent();
                   paraseResult(msg.obj.toString());
                    break;
            }
        }
    };


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

        mMultipleStatusView = (MultipleStatusView)findViewById(R.id.login_status_viwe);
        mMultipleStatusView.showContent();

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
        if (!check()){
            return;
        }
        mMultipleStatusView.showLoading();
        OkHttpClient okHttpClient = OkhttpUtil.getInstance().getOkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("loginName", strUsername)
                .add("password", strPassword)
                .build();
        Request request = new Request.Builder()
                .url(Constants.LOGIN_URL)
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(LOGIN_FAILD);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.i("test",s);
                Message message = handler.obtainMessage();
                message.what = LOGIN_SUCCESS;
                message.obj = s;
                handler.sendMessage(message);
            }
        });
    }

    //解析返回的结果
    private void paraseResult(String result){

        CommonResult<VipUserBean> jsonData = GsonUtils
                .convertBeanFromJson(result,
                        (new TypeToken<CommonResult<VipUserBean>>(){
                        }));

        if (jsonData.header.rspCode.equals("0000")){
            ToastUtil.showShortToast(this,"登录成功");
            SharedPreferencesHelper.saveData(LoginAty.this,Constants.USER_ID,jsonData.body.userid);
        }else{
            ToastUtil.showShortToast(this,jsonData.header.rspDesc);
        }
    }
}

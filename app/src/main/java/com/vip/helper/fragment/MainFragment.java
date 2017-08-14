package com.vip.helper.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vip.helper.R;
import com.vip.helper.adapter.MainGridAdapter;
import com.vip.helper.bean.OrderBean;
import com.vip.helper.global.Constants;
import com.vip.helper.tool.OkhttpUtil;
import com.vip.helper.tool.SharedPreferencesHelper;
import com.vip.helper.tool.ToastUtil;
import com.vip.helper.ui.WebAty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者：liuliang
 * 时间 2017/7/5 23:09
 * 邮箱：liang.liu@zmind.cn
 */
public class MainFragment extends Fragment implements MainGridAdapter.OnRecyclerViewItemClickListener{
    private View view;

    private RecyclerView gridRecycleView;
    private MainGridAdapter gridAdapter;
    private RecyclerView listRecycleView;

    private List<Integer> gridList;
    private List<OrderBean> orderBeanList;

    private int pageIndex = 0;
    public static final int GET_DATA_FAILD = 10;
    public static final int GET_DATA_SUCCESS = 20;

    private double lon = 23.99;
    private double lat = 123.00;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GET_DATA_FAILD:
                    ToastUtil.showShortToast(getActivity(),"请稍后重试");
                    break;
                case GET_DATA_SUCCESS:
                    paraseDate(msg.obj.toString());
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        return view;
    }


    private void initView(){
        gridRecycleView = (RecyclerView)view.findViewById(R.id.main_fragment_gridview);
        //设置布局管理器
        gridRecycleView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        gridList = new ArrayList<>();

        gridList.add(R.drawable.tab_icon_1);
        gridList.add(R.drawable.tab_icon_1);
        gridList.add(R.drawable.tab_icon_1);
        gridList.add(R.drawable.tab_icon_1);

        gridAdapter = new MainGridAdapter(getActivity(),gridList);
        gridAdapter.setOnItemClickListener(this);
        gridRecycleView.setAdapter(gridAdapter);

        listRecycleView = (RecyclerView)view.findViewById(R.id.main_frame_listview);

        getDate();
    }

    //获取轮播广告
    private void getBannerData(){

    }

    //获取列表数据
    private void getDate(){
        OkHttpClient okHttpClient = OkhttpUtil.getInstance().getOkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("exceptUserid", SharedPreferencesHelper.getData(getActivity(),Constants.USER_ID,"")+"")
                .add("page", pageIndex+"")
                .add("pageSize", 10+"")
                .add("lon", lon+"") //维度
                .add("lat", lat+"") //经度
                .build();
        Request request = new Request.Builder()
                .url(Constants.LOGIN_URL)
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(GET_DATA_FAILD);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.i("test",s);
                Message message = handler.obtainMessage();
                message.what = GET_DATA_SUCCESS;
                message.obj = s;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public void onItemClick(View view) {
        Intent intentWeb = new Intent(getActivity(),WebAty.class);
        startActivity(intentWeb);
    }

    @Override
    public void onItemLongClick(View view) {

    }

    //解析请求数据
    private void paraseDate(String result){

    }
}

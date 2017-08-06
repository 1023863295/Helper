package com.vip.helper.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 作者：liuliang
 * 时间 2017/7/16 09:15
 * 邮箱：liang.liu@zmind.cn
 */
public class Header {
    @Expose()
    @SerializedName(value = "rspCode")
    public String rspCode;

    @Expose()
    @SerializedName(value = "rspType")
    public String rspType;


    @Expose()
    @SerializedName(value = "rspTime")
    public String rspTime;


    @Expose()
    @SerializedName(value = "rspDesc")
    public String rspDesc;

}

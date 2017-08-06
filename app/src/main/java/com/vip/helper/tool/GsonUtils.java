package com.vip.helper.tool;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 作者：liuliang
 * 时间 2017/7/16 09:48
 * 邮箱：liang.liu@zmind.cn
 */
public class GsonUtils {
    /**
     * 使用方法，在bean上加注解，@Expose为需要序列化字段，@SerializedName为映射名称
     *
     * @Expose() deserialize serialize
     * @SerializedName(value="param1")
     *
     * */

    static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
            .registerTypeAdapter(String.class, new StringDeserializer())
            .create();

    /**
     *
     * @param json
     * @param type
     *            反序列化泛型类 new TypeToken<TestGeneric<String>>(){}.getType();
     * @return
     */
    public static <E> E convertBeanFromJson(String json, TypeToken type) {
        return (E) gson.fromJson(json, type.getType());
    }
}

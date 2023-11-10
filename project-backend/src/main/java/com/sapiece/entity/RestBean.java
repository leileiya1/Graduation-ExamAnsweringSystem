package com.sapiece.entity;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

/**
 * @Author SAPiece
 * @Create 2023-11-08 12:04
 * @Package com.sapiece.entity
 * @Project GraduationDesign
 * @Filename RestBean
 * @Version 1.0
 */
public record RestBean<T>(int code, T data, String message) {
    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(200, data, "请求成功");
    }

    public static <T> RestBean<T> success() {
        return success(null);
    }

    public String asJsonString() {
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
public static <T> RestBean<T> unauthorized(String message){
        return failure(401,message);
}
    public static <T> RestBean<T> forbidden(String message){
        return failure(403,message);
    }
    public static <T> RestBean<T> failure(int code,String message) {
        return new RestBean<>(code,null,message);
    }
}

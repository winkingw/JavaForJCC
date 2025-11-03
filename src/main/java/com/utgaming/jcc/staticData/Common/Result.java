package com.utgaming.jcc.staticData.Common;

import lombok.Data;

@Data
public class Result<T> {
    // 自定义状态码：200成功，500失败，400参数错误等
    private Integer code;
    // 响应消息
    private String msg;
    // 业务数据
    private T data;

    // 私有构造，防止外部直接实例化
    private Result() {}

    // 成功（不带数据）
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 200;
        result.msg = "操作成功";
        return result;
    }

    // 成功（带数据）
    public static <T> Result<T> success(T data) {
        Result<T> result = success();
        result.code = 200;
        result.data = data;
        return result;
    }

    // 失败（自定义消息）
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.code = 500;
        result.msg = msg;
        return result;
    }
}
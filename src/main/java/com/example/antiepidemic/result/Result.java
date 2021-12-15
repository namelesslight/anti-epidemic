package com.example.antiepidemic.result;

import java.util.Date;

/**
 * 统一返回给前端的封装类
 */
public class Result {

    /**
     * 状态码
     */
    private String code;

    /**
     * 数据
     */
    private Object data;

    /**
     * url路径
     */
    private String path;

    public Result() {
    }

    public Result(String code, Object data, String path) {
        this.code = code;
        this.data = data;
        this.path = path;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", path='" + path + '\'' +
                '}';
    }
}

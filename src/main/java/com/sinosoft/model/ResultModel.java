package com.sinosoft.model;

public class ResultModel {

    /**
     * 标志
     */
    private int code = 0;
    /**
     * 是否成功标志
     */
    private boolean result = false;

    /**
     * 详细信息
     */
    private String detail = null;

    /**
     * 数据
     */
    private Object data;

    /**
     * 条数
     */
    private int count;

    public ResultModel() {}

    public ResultModel(Object data, int count) {
        this.result = true;
        this.detail = "success";
        this.data = data;
        this.count = count;
    }

    public ResultModel(boolean result, String detail, Object data) {
        this.result = result;
        this.detail = detail;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

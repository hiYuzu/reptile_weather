package com.sinosoft.model;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/3/10 16:36
 */
public class ErrorWeatherModel {
    private String status;
    private String status_code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }
}

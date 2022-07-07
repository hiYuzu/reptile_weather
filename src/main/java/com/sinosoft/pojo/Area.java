package com.sinosoft.pojo;

import java.io.Serializable;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/12/15 17:29
 */
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String provinceName;
    private String cityName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}

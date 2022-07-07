package com.sinosoft.util;

/**
 * 直辖市
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/30 10:23
 */
public enum MunicipalityEnum {
    /**
     * 北京
     */
    BEIJING("北京"),
    /**
     * 上海
     */
    SHANGHAI("上海"),
    /**
     * 天津
     */
    TIANJIN("天津"),
    /**
     * 重庆
     */
    CHONGQING("重庆");

    private String name;

    MunicipalityEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean isMunicipality(String provinceName) {
        return provinceName.equals(BEIJING.getName()) || provinceName.equals(SHANGHAI.getName()) || provinceName.equals(TIANJIN.getName()) || provinceName.equals(CHONGQING.getName());
    }
}

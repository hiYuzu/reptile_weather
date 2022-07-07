package com.sinosoft.util;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/12/1 10:04
 */
public enum SpecRegionEnum {
    /**
     * 香港
     */
    HONGKONG("香港"),
    /**
     * 澳门
     */
    MACAO("澳门");

    private String name;

    SpecRegionEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean isSpecRegion(String provinceName) {
        return provinceName.equals(HONGKONG.getName()) || provinceName.equals(MACAO.getName());
    }
}

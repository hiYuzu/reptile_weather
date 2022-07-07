package com.sinosoft.util;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/12/1 9:49
 */
public enum AutoRegionEnum {
    /**
     * 内蒙古
     */
    NEIMENGGU("内蒙古", "自治区"),
    /**
     * 广西
     */
    GUANGXI("广西", "壮族自治区"),
    /**
     * 西藏
     */
    XIZANG("西藏", "自治区"),
    /**
     * 宁夏
     */
    NINGXIA("宁夏", "回族自治区"),
    /**
     * 新疆
     */
    XINJIANG("新疆", "维吾尔自治区");

    private String name;
    private String suf;

    AutoRegionEnum(String name, String suf) {
        this.name = name;
        this.suf = suf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuf() {
        return suf;
    }

    public void setSuf(String suf) {
        this.suf = suf;
    }

    public static AutoRegionEnum getAutoRegion(String provinceName) {
        if (provinceName.equals(NEIMENGGU.getName())) {
            return NEIMENGGU;
        } else if (provinceName.equals(GUANGXI.getName())) {
            return GUANGXI;
        } else if (provinceName.equals(XIZANG.getName())) {
            return XIZANG;
        } else if (provinceName.equals(NINGXIA.getName())) {
            return NINGXIA;
        } else if (provinceName.equals(XINJIANG.getName())) {
            return XINJIANG;
        } else {
            return null;
        }
    }
}

package com.sinosoft.util;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/3/10 16:42
 */
public enum WeatherCodeEnum {
    /**
     * 天气错误心知状态码
     */
    AP010001("AP010001", "API 请求参数错误"),
    AP010002("AP010002", "没有权限访问这个 API 接口"),
    AP010003("AP010003", "API 密钥 key 错误"),
    AP010004("AP010004", "签名错误"),
    AP010005("AP010005", "你请求的 API 不存在"),
    AP010006("AP010006", "没有权限访问这个地点"),
    AP010007("AP010007", "JSONP 请求需要使用签名验证方式"),
    AP010008("AP010008", "没有绑定域名"),
    AP010009("AP010009", "API 请求的 user-agent 与你设置的不一致"),
    AP010010("AP010010", "没有这个地点"),
    AP010011("AP010011", "无法查找到指定 IP 地址对应的城市"),
    AP010012("AP010012", "你的服务已经过期"),
    AP010013("AP010013", "访问量余额不足"),
    AP010014("AP010014", "访问频率超过限制"),
    AP010015("AP010015", "暂不支持该城市的车辆限行信息"),
    AP010016("AP010016", "暂不支持该城市的潮汐数据"),
    AP010017("AP010017", "请求的坐标超出支持的范围"),
    AP100001("AP100001", "系统内部错误：数据缺失"),
    AP100002("AP100002", "系统内部错误：数据错误"),
    AP100003("AP100003", "系统内部错误：服务内部错误"),
    AP100004("AP100004", "系统内部错误：网关错误");

    public static WeatherCodeEnum getByApCode(String apCode) {
        Optional<WeatherCodeEnum> op = Arrays.stream(WeatherCodeEnum.values()).filter(e -> e.apCode.equals(apCode)).findFirst();
        return op.orElse(null);
    }

    WeatherCodeEnum(String apCode, String description) {
        this.apCode = apCode;
        this.description = description;
    }

    private String apCode;
    private String description;

    public String getApCode() {
        return apCode;
    }

    public void setApCode(String apCode) {
        this.apCode = apCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.sinosoft.service;

import java.util.List;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/12/15 17:32
 */
public interface IAreaService {
    /***
     * 获取省份列表
     *
     * @return 省份列表
     */
    List<String> getProvince();

    /***
     * 获取城市列表
     *
     * @param provinceName 省份名称
     * @return 省份列表
     */
    List<String> getCity(String provinceName);
}

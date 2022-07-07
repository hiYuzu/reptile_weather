package com.sinosoft.service;

import com.sinosoft.pojo.TempDayPojo;

import java.util.List;
import java.util.Map;

/**
 * 按城市划分每日温度- 用于年度统计 服务类
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/29 17:53
 */
public interface ITempDayService {
    /**
     * 保存
     *
     * @param tempDayPojo 数据实体类
     */
    void save(TempDayPojo tempDayPojo);

    /**
     * 查询最新的天气数据
     *
     * @return 重新封装的天气数据
     * @throws Exception 异常
     */
    Map<String, List<String>> queryTodayTemp() throws Exception;

    /**
     * 查询指定城市的天气情况-总数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param cityName 城市名
     * @return 日天气数据-总数
     */
    int getTempListCountByCity(String startTime, String endTime, String cityName);

    /**
     * 查询指定城市的天气情况
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param cityName 城市名
     * @param page 页码
     * @param limit 数量
     * @return 日天气数据
     */
    List<TempDayPojo> getTempListByCity(String startTime, String endTime, String cityName, Integer page, Integer limit);

    /**
     * 查询指定省份的天气情况-总数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param provinceName 省份名
     * @return 日天气数据-总数
     */
    int getTempListCountByProvince(String startTime, String endTime, String provinceName);

    /**
     * 查询指定省份的天气情况
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param provinceName 省份名
     * @param page 页码
     * @param limit 数量
     * @return 日天气数据
     */
    List<TempDayPojo> getTempListByProvince(String startTime, String endTime, String provinceName, Integer page, Integer limit);
}

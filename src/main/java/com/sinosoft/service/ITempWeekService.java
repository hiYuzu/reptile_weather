package com.sinosoft.service;

import com.sinosoft.pojo.TempWeekPojo;

import java.util.List;
import java.util.Map;

/**
 * 按城市划分每日温度- 用于年度统计 服务类
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/29 17:53
 */
public interface ITempWeekService {

    /**
     * 保存
     *
     * @param tempWeekPojo 7天数据实体类
     */
    void save(TempWeekPojo tempWeekPojo);

    /**
     * 删除所有
     */
    void deleteAll();

    /**
     * 查询指定省份的天气情况-总数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param provinceName 省份名
     * @return 气温信息-总数
     */
    int getTempListCountByProvince(String startTime, String endTime, String provinceName);

    /**
     * 获取指定省份气温信息
     *
     * @param startTime    开始时间
     * @param endTime      结束时间
     * @param provinceName 省
     * @param page 页码
     * @param limit 数量
     * @return 气温信息
     */
    List<Map<String, String>> getTempListByProvince(String startTime, String endTime, String provinceName, Integer page, Integer limit);

    /**
     * 查询指定城市的天气情况-总数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param cityName 城市名
     * @return 气温信息-总数
     */
    int getTempListCountByCity(String startTime, String endTime, String cityName);

    /**
     * 获取指定城市气温信息
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param cityName  市
     * @param page 页码
     * @param limit 数量
     * @return 气温信息
     */
    List<Map<String, String>> getTempListByCity(String startTime, String endTime, String cityName, Integer page, Integer limit);

    /**
     * 查询7天的平均天气数据
     *
     * @return 重新封装的天气数据
     */
    Map<String, List<String>> queryWeekTemp();

}

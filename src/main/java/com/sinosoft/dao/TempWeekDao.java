package com.sinosoft.dao;

import com.sinosoft.pojo.TempWeekPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 按城市划分每日温度- 用于年度统计 Mapper 接口
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/29 17:53
 */
@Repository
public interface TempWeekDao {

    /**
     * 保存
     *
     * @param tblCityTemperature7Days 7天数据实体类
     */
    void save(@Param("entity") TempWeekPojo tblCityTemperature7Days);

    /**
     * 删除所有
     */
    void deleteAll();

    /**
     * 查询指定城市的天气情况-总数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param cityName 城市名
     * @return 日天气数据-总数
     */
    int getTempListCountByCity(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("cityName") String cityName);

    /**
     * 查询指定省份的天气情况-总数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param provinceName 省份名
     * @return 日天气数据-总数
     */
    int getTempListCountByProvince(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("provinceName") String provinceName);

    /**
     * 获取指定省份气温信息
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param provinceName 省
     * @param page 页码
     * @param limit 数量
     * @return 气温信息
     */
    List<TempWeekPojo> getTempListByProvince(@Param("startTime") String startTime,
                                             @Param("endTime") String endTime,
                                             @Param("provinceName") String provinceName,
                                             @Param("page") Integer page,
                                             @Param("limit") Integer limit);

    /**
     * 获取指定城市气温信息
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param cityName 市
     * @param page 页码
     * @param limit 数量
     * @return 气温信息
     */
    List<TempWeekPojo> getTempListByCity(@Param("startTime") String startTime,
                                         @Param("endTime") String endTime,
                                         @Param("cityName") String cityName,
                                         @Param("page") Integer page,
                                         @Param("limit") Integer limit);


    /**
     * 查询最近一周温度数据（平均）
     *
     * @return 数据
     */
    List<TempWeekPojo> queryWeekTemp();
}

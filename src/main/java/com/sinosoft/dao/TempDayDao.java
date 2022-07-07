package com.sinosoft.dao;

import com.sinosoft.pojo.TempDayPojo;
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
public interface TempDayDao {
    /**
     * 保存
     *
     * @param tblCityTemperatureDay 数据实体类
     */
    void save(@Param("entity") TempDayPojo tblCityTemperatureDay);

    /**
     * 查询指定日期温度数据
     *
     * @param date 日期
     * @return 数据
     */
    List<TempDayPojo> queryTempByDate(String date);

    /**
     * 查询指定日期温度数据量
     *
     * @param date 日期
     * @return 数量
     */
    int queryCountByDate(String date);

    /**
     * 查询指定城市的天气情况
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param cityName  城市名
     * @param page 页码
     * @param limit 数量
     * @return 日天气数据
     */
    List<TempDayPojo> getTempListByCity(@Param("startTime") String startTime,
                                        @Param("endTime") String endTime,
                                        @Param("cityName") String cityName,
                                        @Param("page") Integer page,
                                        @Param("limit") Integer limit);

    /**
     * 查询指定省份的天气情况
     *
     * @param startTime    开始时间
     * @param endTime      结束时间
     * @param provinceName 省份名
     * @param page 页码
     * @param limit 数量
     * @return 日天气数据
     */
    List<TempDayPojo> getTempListByProvince(@Param("startTime") String startTime,
                                            @Param("endTime") String endTime,
                                            @Param("provinceName") String provinceName,
                                            @Param("page") Integer page,
                                            @Param("limit") Integer limit);

    /**
     * 查询指定城市的天气情况-总数
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param cityName  城市名
     * @return 日天气数据-总数
     */
    int getTempListCountByCity(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("cityName") String cityName);

    /**
     * 查询指定省份的天气情况-总数
     *
     * @param startTime    开始时间
     * @param endTime      结束时间
     * @param provinceName 省份名
     * @return 日天气数据-总数
     */
    int getTempListCountByProvince(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("provinceName") String provinceName);
}

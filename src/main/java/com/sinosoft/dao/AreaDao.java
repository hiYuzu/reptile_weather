package com.sinosoft.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地区
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/12/15 17:33
 */
@Repository
public interface AreaDao {
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
    List<String> getCity(@Param("provinceName") String provinceName);
}

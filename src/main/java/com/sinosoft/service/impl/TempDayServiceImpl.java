package com.sinosoft.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sinosoft.dao.TempDayDao;
import com.sinosoft.pojo.TempDayPojo;
import com.sinosoft.service.ITempDayService;
import com.sinosoft.util.AutoRegionEnum;
import com.sinosoft.util.DateUtil;
import com.sinosoft.util.MunicipalityEnum;
import com.sinosoft.util.SpecRegionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 按城市划分每日温度- 用于年度统计 服务实现类
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/29 17:53
 */
@Service
public class TempDayServiceImpl implements ITempDayService {
    private final Logger LOG = LoggerFactory.getLogger(ITempDayService.class);

    @Resource
    private TempDayDao tempDayDao;

    @Override
    public void save(TempDayPojo tempDayPojo) {
        tempDayDao.save(tempDayPojo);
    }

    @Override
    public Map<String, List<String>> queryTodayTemp() throws Exception {
        Map<String, List<String>> result = new HashMap<>(9);
        String date = getNearDate(0);
//        String date = DateUtil.getCurrentDate();
        List<TempDayPojo> tempList = tempDayDao.queryTempByDate(date);
        List<String> redName = new ArrayList<>();
        List<String> redValue = new ArrayList<>();
        List<String> yellowName = new ArrayList<>();
        List<String> yellowValue = new ArrayList<>();
        List<String> blueName = new ArrayList<>();
        List<String> blueValue = new ArrayList<>();
        for (TempDayPojo temp : tempList) {
            String maxTemp = temp.getMaximumTemp();
            float maxTempF;
            String provinceName = temp.getProvinceName();
            String cityName = temp.getCityName();
            String provinceSuf = StrUtil.EMPTY;
            String citySuf = StrUtil.EMPTY;
            if (MunicipalityEnum.isMunicipality(provinceName)) {
                provinceSuf = "市";
                citySuf = "区";
            } else if (SpecRegionEnum.isSpecRegion(provinceName)) {
                provinceSuf = "特别行政区";
            } else {
                AutoRegionEnum autoRegion = AutoRegionEnum.getAutoRegion(provinceName);
                if (autoRegion != null) {
                    provinceSuf = autoRegion.getSuf();
                } else {
                    provinceSuf = "省";
                }
            }
            try {
                maxTempF = Float.parseFloat(maxTemp);
                if (maxTempF >= 30) {
                    redName.add(provinceName + provinceSuf + cityName + citySuf);
                    redValue.add(maxTemp + "℃");
                } else if (maxTempF >= 6) {
                    yellowName.add(provinceName + provinceSuf + cityName + citySuf);
                    yellowValue.add(maxTemp + "℃");
                } else {
                    blueName.add(provinceName + provinceSuf + cityName + citySuf);
                    blueValue.add(maxTemp + "℃");
                }
            } catch (NumberFormatException pe1) {
                LOG.warn("错误：date->" + date + ", city->" + temp.getCityName() + ", maxTemp->" + pe1.getMessage());

                String minTemp = temp.getMinimumTemp();
                float minTempF;
                try {
                    minTempF = Float.parseFloat(minTemp);
                    if (minTempF >= 30) {
                        redName.add(provinceName + provinceSuf + cityName + citySuf);
                        redValue.add(minTemp + "℃");
                    } else if (minTempF >= 6) {
                        yellowName.add(provinceName + provinceSuf + cityName + citySuf);
                        yellowValue.add(minTemp + "℃");
                    } else {
                        blueName.add(provinceName + provinceSuf + cityName + citySuf);
                        blueValue.add(minTemp + "℃");
                    }
                } catch (NumberFormatException pe2) {
                    LOG.warn("错误：date->" + date + ", city->" + temp.getCityName() + ", minTemp->" + pe2.getMessage());
                }
            }
        }
        result.put("redName", redName);
        result.put("redValue", redValue);
        result.put("yellowName", yellowName);
        result.put("yellowValue", yellowValue);
        result.put("blueName", blueName);
        result.put("blueValue", blueValue);
        return result;
    }

    @Override
    public List<TempDayPojo> getTempListByCity(String startTime, String endTime, String cityName, Integer page, Integer limit) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        }
        return tempDayDao.getTempListByCity(startTime, endTime, cityName, page, limit);
    }

    @Override
    public List<TempDayPojo> getTempListByProvince(String startTime, String endTime, String provinceName, Integer page, Integer limit) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        }
        return tempDayDao.getTempListByProvince(startTime, endTime, provinceName, page, limit);
    }

    @Override
    public int getTempListCountByCity(String startTime, String endTime, String cityName) {
        return tempDayDao.getTempListCountByCity(startTime, endTime, cityName);
    }

    @Override
    public int getTempListCountByProvince(String startTime, String endTime, String provinceName) {
        return tempDayDao.getTempListCountByProvince(startTime, endTime, provinceName);
    }

    private String getNearDate(int i) throws Exception {
        final int minDay = -7;
        String date = DateUtil.getSpecDate(i);
        int count = tempDayDao.queryCountByDate(date);
        if (count > 0) {
            return date;
        } else {
            i--;
            if (i < minDay) {
                throw new Exception("近一周内无数据！");
            }
            return getNearDate(i);
        }
    }
}

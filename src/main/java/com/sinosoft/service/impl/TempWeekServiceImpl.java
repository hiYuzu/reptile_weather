package com.sinosoft.service.impl;

import com.sinosoft.dao.TempWeekDao;
import com.sinosoft.pojo.TempWeekPojo;
import com.sinosoft.service.ITempWeekService;
import com.sinosoft.util.MunicipalityEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 按城市划分每日温度- 用于年度统计 服务实现类
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/29 17:53
 */
@Service
public class TempWeekServiceImpl implements ITempWeekService {
    private final Logger LOG = LoggerFactory.getLogger(TempWeekServiceImpl.class);

    @Resource
    private TempWeekDao tempWeekDao;

    @Override
    public void deleteAll() {
        tempWeekDao.deleteAll();
    }

    @Override
    public List<Map<String, String>> getTempListByProvince(String startTime, String endTime, String provinceName, Integer page, Integer limit) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        }
        List<TempWeekPojo> listByProvince = tempWeekDao.getTempListByProvince(startTime, endTime, provinceName, page, limit);
        return getFinalList(listByProvince);
    }

    private List<Map<String, String>> getFinalList(List<TempWeekPojo> listByProvince) {

        // 最终结果集
        List<Map<String, String>> resultList = new LinkedList<>();

        Set<String> cityNameList = new LinkedHashSet<>();

        // 遍历第一次, 获取城市名称集合, 表示最后要展示多少条数据
        listByProvince.forEach(item -> cityNameList.add(item.getCityName()));

        for (String cityName : cityNameList) {
            // 当前城市的最终map, 也称为模板map
            Map<String, String> curResultMap = new LinkedHashMap<>(16);
            // 当前城市的过滤集合(长度为7天)
            List<TempWeekPojo> curCityList = listByProvince.stream().filter(item -> cityName.equalsIgnoreCase(item.getCityName())).collect(Collectors.toList());
            for (int i = 0; i < curCityList.size(); i++) {
                TempWeekPojo tblCityTemperature7Days = curCityList.get(i);
                if (i == 0) {
                    curResultMap.put("provinceName", tblCityTemperature7Days.getProvinceName());
                    curResultMap.put("cityName", tblCityTemperature7Days.getCityName());
                    curResultMap.put("curTime" + (i+1), tblCityTemperature7Days.getCurTime().toString());
                    curResultMap.put("maximumTemp" + (i+1), tblCityTemperature7Days.getMaximumTemp());
                    curResultMap.put("minimumTemp" + (i+1), tblCityTemperature7Days.getMinimumTemp());
                } else {
                    curResultMap.put("curTime" + (i+1), tblCityTemperature7Days.getCurTime().toString());
                    curResultMap.put("maximumTemp" + (i+1), tblCityTemperature7Days.getMaximumTemp());
                    curResultMap.put("minimumTemp" + (i+1), tblCityTemperature7Days.getMinimumTemp());
                }
            }
            resultList.add(curResultMap);
        }
        return resultList;
    }

    @Override
    public List<Map<String, String>> getTempListByCity(String startTime, String endTime, String cityName, Integer page, Integer limit) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        }
        List<TempWeekPojo> tempListByCity = tempWeekDao.getTempListByCity(startTime, endTime, cityName, page, limit);
        return getFinalList(tempListByCity);
    }

    @Override
    public int getTempListCountByProvince(String startTime, String endTime, String provinceName) {
        return tempWeekDao.getTempListCountByProvince(startTime, endTime, provinceName);
    }

    @Override
    public int getTempListCountByCity(String startTime, String endTime, String cityName) {
        return tempWeekDao.getTempListCountByCity(startTime, endTime, cityName);
    }

    @Override
    public void save(TempWeekPojo tempWeekPojo) {
        tempWeekDao.save(tempWeekPojo);
    }

    @Override
    public Map<String, List<String>> queryWeekTemp() {
        Map<String, List<String>> result = new HashMap<>(9);
        List<TempWeekPojo> tempList = tempWeekDao.queryWeekTemp();
        List<String> redName = new ArrayList<>();
        List<String> redValue = new ArrayList<>();
        List<String> yellowName = new ArrayList<>();
        List<String> yellowValue = new ArrayList<>();
        List<String> blueName = new ArrayList<>();
        List<String> blueValue = new ArrayList<>();
        for (TempWeekPojo temp : tempList) {
            String maxTemp = temp.getMaximumTemp();
            float maxTempF;
            try {
                maxTempF = Float.parseFloat(maxTemp);
                String provinceName = temp.getProvinceName();
                String cityName = temp.getCityName();
                String provinceSuf = MunicipalityEnum.isMunicipality(provinceName) ? "市" : "省";
                String citySuf = MunicipalityEnum.isMunicipality(provinceName) ? "区" : "市";
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
                LOG.warn("错误：city->" + temp.getCityName() + ", maxTemp->" + pe1.getMessage());

                String minTemp = temp.getMinimumTemp();
                float minTempF;
                try {
                    minTempF = Float.parseFloat(minTemp);
                    String provinceName = temp.getProvinceName();
                    String cityName = temp.getCityName();
                    String provinceSuf = MunicipalityEnum.isMunicipality(provinceName) ? "市" : "省";
                    String citySuf = MunicipalityEnum.isMunicipality(provinceName) ? "区" : "市";
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
                    LOG.warn("错误：city->" + temp.getCityName() + ", minTemp->" + pe2.getMessage());
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
}

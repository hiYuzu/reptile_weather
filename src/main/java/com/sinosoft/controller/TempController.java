package com.sinosoft.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.sinosoft.model.ErrorWeatherModel;
import com.sinosoft.model.NowWeatherModel;
import com.sinosoft.model.ResultModel;
import com.sinosoft.pojo.TempDayPojo;
import com.sinosoft.service.ITempWeekService;
import com.sinosoft.service.ITempDayService;
import com.sinosoft.util.DefaultParam;
import com.sinosoft.util.HttpStatus;
import com.sinosoft.util.RealWeatherUtil;
import com.sinosoft.util.WeatherCodeEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import java.util.List;
import java.util.Map;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/30 9:43
 */
@RestController
@RequestMapping("temp")
public class TempController {
    @Resource
    private ITempDayService tempDayService;
    @Resource
    private ITempWeekService tempWeekService;

    private final String ALL = "全国";

    @RequestMapping("day")
    @ResponseBody
    public ResultModel getTempDay() {
        try {
            Map<String, List<String>> resultMap = tempDayService.queryTodayTemp();
            return new ResultModel(resultMap, resultMap.size());
        } catch (Exception e) {
            return new ResultModel(false, e.getMessage(), null);
        }
    }

    @RequestMapping("week")
    @ResponseBody
    public ResultModel getTempWeek() {
        try {
            Map<String, List<String>> resultMap = tempWeekService.queryWeekTemp();
            return new ResultModel(resultMap, resultMap.size());
        } catch (Exception e) {
            return new ResultModel(false, e.getMessage(), null);
        }
    }

    @RequestMapping("getDayByCity")
    @ResponseBody
    public ResultModel getDayTempListByCity(String startTime, String endTime, String cityName, Integer page, Integer limit) {
        int count = tempDayService.getTempListCountByCity(startTime, endTime, cityName);
        List<TempDayPojo> result = tempDayService.getTempListByCity(startTime, endTime, cityName, page, limit);
        return new ResultModel(result, count);
    }

    @RequestMapping("expDayByCity")
    public void expDayByCity(String startTime, String endTime, String cityName, HttpServletResponse response) {
        List<TempDayPojo> result = tempDayService.getTempListByCity(startTime, endTime, cityName, null, null);
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(result, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=weather.xls");
        try {
            ServletOutputStream out = response.getOutputStream();
            writer.flush(out, true);
            writer.close();
            IoUtil.close(out);
        } catch (Exception e) {
            e.printStackTrace();
            writer.close();
        }
    }

    @RequestMapping("getDayByProvince")
    @ResponseBody
    public ResultModel getDayTempListByProvince(String startTime, String endTime, String provinceName, Integer page, Integer limit) {
        if (ALL.equals(provinceName)) {
            provinceName = StrUtil.EMPTY;
        }
        int count = tempDayService.getTempListCountByProvince(startTime, endTime, provinceName);
        List<TempDayPojo> result = tempDayService.getTempListByProvince(startTime, endTime, provinceName, page, limit);
        return new ResultModel(result, count);
    }

    @RequestMapping("expDayByProvince")
    public void expDayByProvince(String startTime, String endTime, String provinceName, HttpServletResponse response) {
        if (ALL.equals(provinceName)) {
            provinceName = StrUtil.EMPTY;
        }
        List<TempDayPojo> result = tempDayService.getTempListByProvince(startTime, endTime, provinceName, null, null);
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(result, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=weather.xls");
        try {
            ServletOutputStream out = response.getOutputStream();
            writer.flush(out, true);
            writer.close();
            IoUtil.close(out);
        } catch (Exception e) {
            e.printStackTrace();
            writer.close();
        }
    }

    @RequestMapping("getWeekByCity")
    @ResponseBody
    public ResultModel getWeekTempListByCity(String startTime, String endTime, String cityName, Integer page, Integer limit) {
        int count = tempWeekService.getTempListCountByCity(startTime, endTime, cityName);
        List<Map<String, String>> result = tempWeekService.getTempListByCity(startTime, endTime, cityName, page, limit);
        return new ResultModel(result, count);
    }

    @RequestMapping("getWeekByProvince")
    @ResponseBody
    public ResultModel getWeekTempListByProvince(String startTime, String endTime, String provinceName, Integer page, Integer limit) {
        if (ALL.equals(provinceName)) {
            provinceName = StrUtil.EMPTY;
        }
        int count = tempWeekService.getTempListCountByProvince(startTime, endTime, provinceName);
        List<Map<String, String>> result = tempWeekService.getTempListByProvince(startTime, endTime, provinceName, page, limit);
        return new ResultModel(result, count);
    }

    @RequestMapping("getAvgAreaTemp")
    @ResponseBody
    public ResultModel getAvgAreaTemp() {
        try {
            HttpResponse response = HttpRequest.get(RealWeatherUtil.generateNowUrl()).execute();
            int statusCode = response.getStatus();
            JSONObject jsonObject = JSONUtil.parseObj(response.body());
            if (statusCode == HttpStatus.HTTP_OK) {
                NowWeatherModel nowWeatherModel = JSONUtil.toBean(jsonObject, NowWeatherModel.class);
                String temp = nowWeatherModel.getResults().get(0).getNow().getTemperature();
                if (Double.parseDouble(temp) > DefaultParam.HIGH_TEMP) {
                    return new ResultModel(true, "success", temp);
                } else {
                    return new ResultModel(false, "无高温预警", temp);
                }
            } else {
                ErrorWeatherModel error = JSONUtil.toBean(jsonObject, ErrorWeatherModel.class);
                return new ResultModel(false, WeatherCodeEnum.getByApCode(error.getStatus_code()).getDescription(), null);
            }

        } catch (SignatureException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResultModel(false, e.getMessage(), null);
        }
    }
}

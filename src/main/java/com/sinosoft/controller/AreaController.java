package com.sinosoft.controller;

import cn.hutool.core.util.StrUtil;
import com.sinosoft.model.ResultModel;
import com.sinosoft.service.IAreaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/12/15 17:14
 */
@RestController
@RequestMapping("area")
public class AreaController {
    @Resource
    private IAreaService areaService;

    @RequestMapping("getProvince")
    @ResponseBody
    public ResultModel getProvince() {
        List<String> result = areaService.getProvince();
        return new ResultModel(result, result.size());
    }

    @RequestMapping("getCity")
    @ResponseBody
    public ResultModel getProvince(@RequestParam("provinceName") String provinceName) {
        String all = "全国";
        if (all.equals(provinceName)) {
            provinceName = StrUtil.EMPTY;
        }
        List<String> result = areaService.getCity(provinceName);
        return new ResultModel(result, result.size());
    }
}

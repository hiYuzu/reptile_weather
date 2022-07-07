package com.sinosoft.service.impl;

import com.sinosoft.dao.AreaDao;
import com.sinosoft.service.IAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/12/15 17:32
 */
@Service
public class AreaServiceImpl implements IAreaService {
    @Resource
    private AreaDao areaDao;

    @Override
    public List<String> getProvince() {
        return areaDao.getProvince();
    }

    @Override
    public List<String> getCity(String provinceName) {
        return areaDao.getCity(provinceName);
    }
}

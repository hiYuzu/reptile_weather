package com.sinosoft.service.impl;

import com.sinosoft.dao.IUserDao;
import com.sinosoft.pojo.UserPojo;
import com.sinosoft.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户接口实现
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/29 17:53
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public int getUserCount(UserPojo userPojo) {
        return userDao.getUserCount(userPojo);
    }

    @Override
    public List<UserPojo> getUser(UserPojo userPojo) {
        return userDao.getUser(userPojo);
    }

    @Override
    public int insertUser(UserPojo userPojo) {
        int result;
        if (userPojo != null) {
            result = userDao.insertUser(userPojo);
        } else {
            result = 0;
        }
        return result;
    }

    @Override
    public int updateUser(UserPojo userPojo) {
        return userDao.updateUser(userPojo);
    }

    @Override
    public int updateUserPassword(String userId, String userPassword) {
        return userDao.updateUserPassword(userId, userPassword);
    }

    @Override
    public int updateUserLoginTime(String userId, String endTime) {
        return userDao.updateUserLoginTime(userId, endTime);
    }

    @Override
    public int deleteUsers(List<String> idList) {
        return userDao.deleteUser(idList);
    }

    @Override
    public int existUpdateUser(String userId, String userCode) {
        return userDao.existUpdateUser(userId, userCode);
    }

    @Override
    public String getUserCodeById(String userId) {
        return userDao.getUserCodeById(userId);
    }

    @Override
    public String getUserTypeById(String userId) {
        return userDao.getUserTypeById(userId);
    }

    @Override
    public int existDeliverUser(String userId) {
        return userDao.existDeliverUser(userId);
    }
}

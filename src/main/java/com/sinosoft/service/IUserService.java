package com.sinosoft.service;

import com.sinosoft.pojo.UserPojo;

import java.util.List;

/**
 * 用户接口
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/29 17:53
 */
public interface IUserService {

    /**
     * 查询用户个数
     *
     * @param userPojo 用户实体参数
     * @return 操作量
     */
    int getUserCount(UserPojo userPojo);

    /**
     * 查询用户数据
     *
     * @param userPojo 用户实体参数
     * @return 用户数据
     */
    List<UserPojo> getUser(UserPojo userPojo);

    /**
     * 添加用户
     *
     * @param userPojo 用户实体参数
     * @return 操作量
     * @throws Exception 异常
     */
    int insertUser(UserPojo userPojo) throws Exception;

    /**
     * 更新用户
     *
     * @param userPojo 用户实体参数
     * @return 操作量
     * @throws Exception 异常
     */
    int updateUser(UserPojo userPojo) throws Exception;

    /**
     * 更新用户密码
     *
     * @param userId       用户id
     * @param userPassword 用户密码
     * @return 操作量
     * @throws Exception 异常
     */
    int updateUserPassword(String userId, String userPassword) throws Exception;

    /**
     * 更新用户登录时间
     *
     * @param userId  用户id
     * @param endTime 最后一次登录时间
     * @return 操作量
     */
    int updateUserLoginTime(String userId, String endTime);

    /**
     * 删除用户
     *
     * @param idList 用户idList
     * @return 操作量
     * @throws Exception 异常
     */
    int deleteUsers(List<String> idList) throws Exception;

    /**
     * 存在此用户（更新时）
     *
     * @param userId   用户id
     * @param userCode userCode
     * @return 操作量
     */
    int existUpdateUser(String userId, String userCode);

    /**
     * 通过userId获取userCode
     *
     * @param userId 用户id
     * @return userCode
     */
    String getUserCodeById(String userId);

    /**
     * 通过userId获取userType
     *
     * @param userId 用户id
     * @return userType
     */
    String getUserTypeById(String userId);

    /**
     * 检查是否存在订单已用用户
     *
     * @param userId 用户id
     * @return 操作量
     */
    int existDeliverUser(String userId);

}

package com.sinosoft.dao;

import com.sinosoft.pojo.UserPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/12/15 17:33
 */
@Repository
public interface IUserDao {

    /**
     * 查询用户个数
     *
     * @param userPojo 用户实体参数
     * @return 用户个数
     */
    int getUserCount(@Param("userPojo") UserPojo userPojo);

    /**
     * 查询用户数据
     *
     * @param userPojo 用户实体参数
     * @return 用户实体
     */
    List<UserPojo> getUser(@Param("userPojo") UserPojo userPojo);

    /**
     * 新增用户数据
     *
     * @param userPojo 用户实体参数
     * @return 操作量
     */
    int insertUser(@Param("userPojo") UserPojo userPojo);

    /**
     * 更新用户数据
     *
     * @param userPojo 用户实体参数
     * @return 操作量
     */
    int updateUser(@Param("userPojo") UserPojo userPojo);

    /**
     * 更新用户密码
     *
     * @param userId       用户id
     * @param userPassword 密码
     * @return 操作量
     */
    int updateUserPassword(@Param("userId") String userId, @Param("userPassword") String userPassword);

    /**
     * 更新用户登录时间
     *
     * @param userId  用户id
     * @param endTime 最后一次登录时间
     * @return 操作量
     */
    int updateUserLoginTime(@Param("userId") String userId, @Param("endTime") String endTime);

    /**
     * 删除用户数据
     *
     * @param idList 用户idList
     * @return 操作量
     */
    int deleteUser(@Param("idList") List<String> idList);

    /**
     * 存在此用户（更新时）
     *
     * @param userId   用户id
     * @param userCode 用户code
     * @return 操作量
     */
    int existUpdateUser(@Param("userId") String userId, @Param("userCode") String userCode);

    /**
     * 通过userId获取userCode
     *
     * @param userId 用户id
     * @return userCode
     */
    String getUserCodeById(@Param("userId") String userId);

    /**
     * 通过userId获取userType
     *
     * @param userId 用户id
     * @return userType
     */
    String getUserTypeById(@Param("userId") String userId);

    /**
     * 检查是否存在订单已用用户
     *
     * @param userId 用户id
     * @return 操作量
     */
    int existDeliverUser(@Param("userId") String userId);

}

package com.sinosoft.controller;

import com.sinosoft.model.ResultModel;
import com.sinosoft.model.UserModel;
import com.sinosoft.pojo.UserPojo;
import com.sinosoft.service.IUserService;
import com.sinosoft.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/12/15 17:14
 */
@Controller
public class LoginController {
    /**
     * 声明日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private IUserService userService;

    @Resource
    private UserController userController;

    @RequestMapping(value = "/")
    public String index() {
        return "html/login";
    }

    @RequestMapping(value = "/login")
    public String login(UserModel userModel, HttpSession httpSession) {
        ResultModel resultModel = validateLogin(userModel, httpSession);
        if (resultModel.isResult()) {
            UserModel sessionUser;
            UserPojo userPojo = userController.convertUserPojo(userModel, true, httpSession);
            List<UserPojo> listUserPojo = userService.getUser(userPojo);
            if (listUserPojo != null && listUserPojo.size() > 0) {
                sessionUser = userController.convertUserModel(listUserPojo.get(0));
                httpSession.setAttribute(httpSession.getId(), sessionUser);
                //更新登录时间
                if (userService.updateUserLoginTime(String.valueOf(listUserPojo.get(0).getUserId()),
                        DateUtil.timestampToString(DateUtil.getSystemDateTime(0), DateUtil.DATETIME)) <= 0) {
                    LOG.error("更新登录时间失败，登录用户为" + listUserPojo.get(0).getUserName());
                }
                return "html/index";
            } else {
                return "html/login";
            }
        } else {
            return "html/login";
        }
    }

    @RequestMapping(value = "/validateLogin", method = {RequestMethod.POST})
    @ResponseBody
    public ResultModel validateLogin(UserModel userModel, HttpSession httpSession) {
        ResultModel resultModel = new ResultModel();
        if (userModel != null && userModel.getUserCode() != null && !userModel.getUserCode().isEmpty()
                && userModel.getUserPassword() != null && !userModel.getUserPassword().isEmpty()) {
            try {
                UserPojo userPojo = userController.convertUserPojo(userModel, true, httpSession);
                int count = userService.getUserCount(userPojo);
                if (count > 0) {
                    resultModel.setResult(true);
                    resultModel.setDetail("登录验证成功");
                } else {
                    resultModel.setResult(false);
                    resultModel.setDetail("用户名或密码验证失败");
                }
            } catch (Exception e) {
                resultModel.setResult(false);
                resultModel.setDetail("登录验证异常，异常信息：" + e.getMessage());
                LOG.error("登录验证异常，异常信息：" + e.getMessage());
            }
        } else {
            resultModel.setResult(false);
            resultModel.setDetail("登录验证信息为空");
        }
        return resultModel;
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public ResultModel logout(@RequestParam(value = "userCode", required = false) String userCode, HttpSession httpSession) {
        httpSession.removeAttribute(httpSession.getId());
        ResultModel resultModel = new ResultModel();
        resultModel.setResult(true);
        resultModel.setDetail("退出系统成功");
        return resultModel;
    }

}

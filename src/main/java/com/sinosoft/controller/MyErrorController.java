package com.sinosoft.controller;

import com.sinosoft.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/9/14 16:54
 */
@Controller
public class MyErrorController extends BasicErrorController {
    @Autowired
    public MyErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);
    }

    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        model.put("customMsg", "出错啦");
        String message;
        switch (status) {
            // 400
            case BAD_REQUEST:
                message = "服务器不理解请求的语法";
                break;
            // 401
            case UNAUTHORIZED:
                message = "当前用户未授权，请尝试重新登陆";
                break;
            // 403
            case FORBIDDEN:
                message = "您的权限不足";
                break;
            // 404
            case NOT_FOUND:
                message = "未找到访问的页面或文件";
                break;
            // 405
            case METHOD_NOT_ALLOWED:
                message = "请求的方法已被服务器禁用";
                break;
            // 500
            case INTERNAL_SERVER_ERROR:
                message = "服务器内部错误，请联系管理员";
                break;
            // 502
            case BAD_GATEWAY:
                message = "网关错误，请联系管理员";
                break;
            // 504
            case GATEWAY_TIMEOUT:
                message = "服务器无法获得响应，请联系管理员";
                break;
            default:
                message = "发生了一点小问题：" + status.getReasonPhrase() + "，请联系管理员";
        }
        model.put("message", message);
        model.put("timestamp", DateUtil.getCurrentTime());

        model.put("scheme", request.getScheme());
        model.put("serverName", request.getServerName());
        model.put("serverPort", request.getServerPort());

        return new ModelAndView("errorPage", model, status);
    }
}

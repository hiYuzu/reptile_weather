package com.sinosoft.util;

import cn.hutool.core.util.StrUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 获取天气公共方法
 *
 * @author zsj
 * @author hiYuzu
 */
@Component
public class PublicUtil {

//    private static final String DRIVER_FILE_PATH = "E:/JavaProject/reptile_weather/chromedriver.exe";
    private static final String DRIVER_FILE_PATH = "D:/reptile_weather/chromedriver.exe";
//       linux 执行时取消注释
//    private static final String DRIVER_FILE_PATH = "/opt/reptile_heat/chromedriver";

    /**
     * 获取配置文件
     *
     * @param file 文件
     * @param key 键值
     * @return 配置
     */
    public static String getPropertiesKey(String file, String key) {
        Resource resource = new ClassPathResource(file);
        EncodedResource encodeRes = new EncodedResource(resource, "utf-8");
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(encodeRes);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取浏览器
     *
     * @param url 链接
     * @param isHide 是否无痕
     * @param waitTime 等待时间
     * @return {@link WebDriver}
     */
    public static WebDriver getWebDriver(String url, boolean isHide, long waitTime) {
        System.setProperty("webdriver.chrome.driver", DRIVER_FILE_PATH);
        // 创建chrome参数对象
        ChromeOptions options = new ChromeOptions();
        // 浏览器后台运行
        if (isHide) {
            options.addArguments("headless");
        }
//       linux 执行时取消注释
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-dev-shm-usage");
        // 谷歌浏览器
        WebDriver driver = new ChromeDriver(options);
        // 清除所有缓存
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     */
    public static String timeStamp2Date(String seconds, String format) {
        final String nullStr = "null";
        if (StrUtil.isBlank(seconds) || seconds.equals(nullStr)) {
            return StrUtil.EMPTY;
        }
        if (StrUtil.isBlank(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.parseLong(seconds)));
    }

    /**
     * 下标传值时, 需要加1天
     *
     * @param day 天
     * @return 日期
     */
    public static Date getDate(int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, (day));
        return cal.getTime();
    }

    /**
     * 获取linux系统时的pid
     *
     * @param content 匹配内容
     * @return pid
     */
    protected static String getPid(String content) {
        BufferedReader reader = null;
        try {
            //显示所有进程
            Process process = Runtime.getRuntime().exec("ps -ef");
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(content)) {
                    String[] strings = line.split("\\s+");
                    return strings[1];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

package com.sinosoft.util;

import cn.hutool.core.util.StrUtil;
import com.sinosoft.pojo.TempDayPojo;
import com.sinosoft.service.ITempDayService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取当天的34个省/自治区、港澳台的气温数据, 一天的量为458条, 31个省/自治区+港澳台下面的市
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2021/11/29 17:53
 */
@Component
public class DomesticCityDataUtilDay {

    @Resource
    private ITempDayService tblCityTemperatureDayService;

    private static DomesticCityDataUtilDay domesticCityDataUtilDay;

    private static final Logger LOG = LoggerFactory.getLogger(DomesticCityDataUtilDay.class);

    /**
     * 各地区天气网址集合(除了港澳台)
     */
    public static final List<String> URLS = new ArrayList<>();

    /**
     * 港澳台单独处理
     */
    public static final String GAT_URL = "http://www.weather.com.cn/textFC/gat.shtml";

    private static final Pattern PATTERN = Pattern.compile("([\u4e00-\u9fa5]+)");

    static {
        URLS.add("http://www.weather.com.cn/textFC/hb.shtml");
        URLS.add("http://www.weather.com.cn/textFC/db.shtml");
        URLS.add("http://www.weather.com.cn/textFC/hd.shtml");
        URLS.add("http://www.weather.com.cn/textFC/hz.shtml");
        URLS.add("http://www.weather.com.cn/textFC/hn.shtml");
        URLS.add("http://www.weather.com.cn/textFC/xb.shtml");
        URLS.add("http://www.weather.com.cn/textFC/xn.shtml");

    }

    @PostConstruct
    public void init() {
        domesticCityDataUtilDay = this;
        domesticCityDataUtilDay.tblCityTemperatureDayService = this.tblCityTemperatureDayService;
    }

    /**
     * 当天各省份下属城市的气温数据(除港澳台)
     *
     * @throws IOException IO异常
     */
    @Transactional(rollbackFor = Throwable.class)
    @Scheduled(cron = "0 55 11 * * ?")
    public void getTemperatureForDay() throws IOException {
        try {
            LOG.info("执行获取当天各省市除港澳台的气温数据, 当前时间:" + PublicUtil.timeStamp2Date(String.valueOf(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss"));

            // 遍历除港澳台的url
            for (String url : URLS) {
                // 30秒等待时间
                final WebDriver webDriver = PublicUtil.getWebDriver(url, true, 30);
                List<WebElement> conMidtab2List = getList(webDriver);
                // 处理集合并入库
                handleResult(conMidtab2List);
                webDriver.close();
                webDriver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        } finally {
//           linux 时注释掉
            Runtime.getRuntime().exec("taskkill /F /im chrome.exe");
            Runtime.getRuntime().exec("taskkill /F /im chromedriver.exe");
//            linux 执行时取消注释
//            String pid1 = PublicUtil.getPid("java -jar chrome");
//            String pid2 = PublicUtil.getPid("java -jar chromedriver");
//            if (pid1 != null) {
//                Runtime.getRuntime().exec("kill -9 " + pid1);
//            }
//            if (pid2 != null) {
//                Runtime.getRuntime().exec("kill -9 " + pid2);
//            }
        }

    }

    /**
     * 当天港澳台的气温数据
     *
     * @throws IOException IO异常
     */
    @Transactional(rollbackFor = Throwable.class)
    @Scheduled(cron = "0 55 12 * * ?")
    public void getTemperatureForDayGat() throws IOException {
        try {
            LOG.info("执行获取当天港澳台的气温数据, 当前时间:" + PublicUtil.timeStamp2Date(String.valueOf(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss"));
            // 30秒等待时间
            final WebDriver webDriver = PublicUtil.getWebDriver(GAT_URL, true, 30);
            List<WebElement> conMidtab2List = getList(webDriver);
            // 处理港澳台集合并入库
            handleResultGat(conMidtab2List);
            webDriver.close();
            webDriver.quit();
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        } finally {
///            linux 时注释掉
            Runtime.getRuntime().exec("taskkill /F /im chrome.exe");
            Runtime.getRuntime().exec("taskkill /F /im chromedriver.exe");
//            linux 执行时取消注释
//            String pid1 = PublicUtil.getPid("java -jar chrome");
//            String pid2 = PublicUtil.getPid("java -jar chromedriver");
//            if (pid1 != null) {
//                Runtime.getRuntime().exec("kill -9 " + pid1);
//            }
//            if (pid2 != null) {
//                Runtime.getRuntime().exec("kill -9 " + pid2);
//            }
        }
    }

    private static List<WebElement> getList(WebDriver webDriver) throws Exception {
        // 60秒超时时间   检测的间隔步长为3秒
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 60, 3);
        WebElement wInfoNo = webDriverWait.until((ExpectedCondition<WebElement>) input -> webDriver.findElement(By.className("hanml")));
        Thread.sleep(2000);

//         长度为7天的conMidtab集合, 表示一周的气象内容,
//         每一个conMidtab里面有对应当天的conMidtab2, 表示每个省的具体气象温度div,
//         此处定时任务为获取当天, 所以取第一个, 即下标为0的

        return wInfoNo.findElements(By.className("conMidtab")).get(0).findElements(By.className("conMidtab2"));
    }

    /**
     * 处理31个省/自治区集合, 并入库
     *
     * @param conMidtab2List 集合
     */
    private static void handleResult(List<WebElement> conMidtab2List) {
        for (WebElement element : conMidtab2List) {
            try {
                // 先找到table下的tbody
                WebElement table = element.findElement(By.tagName("table"));
                WebElement tbody = table.findElement(By.tagName("tbody"));
                List<WebElement> trs = tbody.findElements(By.tagName("tr"));
                // 省份名称
                String provinceName = StrUtil.EMPTY;
                // 省会城市名称
                String provincialCapitalName = StrUtil.EMPTY;
                // 所有省都从2开始取, 因为0和1下标是表头
                for (int i = 2; i < trs.size(); i++) {
                    // 当前城市名称
                    String curCityName = StrUtil.EMPTY;
                    // 匹配汉字, 用于获取省份城市名称
                    Matcher m;
                    WebElement tr = trs.get(i);
                    List<WebElement> td = tr.findElements(By.tagName("td"));
                    // 下标为2的时候, 获取省份名称
                    if (i == 2) {
                        // 下标为2的时候, 获取省份名字, 直辖市的话, 直接取北京, 天津, 上海, 重庆四个名字, 然后进入i==3的循环
                        String provinceHtml = td.get(0).getAttribute("innerHTML");
                        if (provinceHtml.contains("a") && provinceHtml.contains("/")) {
                            m = PATTERN.matcher(provinceHtml);
                            while (m.find()) {
                                provinceName = m.group(0);
                            }
                        }

                        // 用于获取省会城市的名称, 只在i==2的时候, 获取并赋值
                        String cityHtml = td.get(1).getAttribute("innerHTML");
                        if (cityHtml.contains("a") && cityHtml.contains("/")) {
                            m = PATTERN.matcher(cityHtml);
                            while (m.find()) {
                                provincialCapitalName = m.group(0);
                            }
                        }
                    } else {
                        String curCityHtml = td.get(0).getAttribute("innerHTML");
                        if (curCityHtml.contains("a") && curCityHtml.contains("/")) {
                            m = PATTERN.matcher(curCityHtml);
                            while (m.find()) {
                                curCityName = m.group(0);
                            }
                        }
                    }


                    // i为2的时候 td会多一个, 因为首行有个跨行的头部td表示省级名称, 如北京, 四川等
                    if (i == 2) {
                        // 不为北京, 天津, 重庆, 上海的话, 保存省会城市的信息, 例如河北-石家庄
                        if (!("北京".equalsIgnoreCase(provinceName) || "天津".equalsIgnoreCase(provinceName) ||
                                "重庆".equalsIgnoreCase(provinceName) || "上海".equalsIgnoreCase(provinceName))) {
                            String maxTemp = td.get(4).getAttribute("innerHTML");
                            String minTemp = td.get(7).getAttribute("innerHTML");
                            saveResult(provinceName, provincialCapitalName, maxTemp, minTemp);
                        }
                    } else {
//                        if ("辽宁".equalsIgnoreCase(provinceName) && "朝阳".equalsIgnoreCase(curCityName)) {
//                            curCityName = "朝阳市";
//                        }
                        // 非上述四个城市且不为省会城市的时候
                        String maxTemp = td.get(3).getAttribute("innerHTML");
                        String minTemp = td.get(6).getAttribute("innerHTML");

                        saveResult(provinceName, curCityName, maxTemp, minTemp);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
                LOG.error("执行handleResult报错, 具体异常为: " + e.getMessage());
            }
        }
    }

    /**
     * 处理港澳台集合, 并入库
     *
     * @param conMidtab2List 集合
     */
    private static void handleResultGat(List<WebElement> conMidtab2List) {
        for (WebElement element : conMidtab2List) {
            try {
                // 先找到table下的tbody
                List<WebElement> tables = element.findElements(By.tagName("table"));
                for (WebElement table : tables) {
                    WebElement tbody = table.findElement(By.tagName("tbody"));
                    // 找到tr, 北京, 上海, 重庆, 天津四个直辖市的tr只取下标为2的, 因为后面的是各区情况, 目前不需要, 只统计北京的情况
                    List<WebElement> trs = tbody.findElements(By.tagName("tr"));
                    // 省份名称
                    String provinceName = StrUtil.EMPTY;
                    for (int i = 2; i < trs.size(); i++) {
                        String curCityName = StrUtil.EMPTY;
                        // 匹配汉字, 用于获取省份城市名称
                        Matcher m;
                        WebElement tr = trs.get(i);
                        List<WebElement> td = tr.findElements(By.tagName("td"));
                        // 下标为2的时候, 获取省份名称
                        if (i == 2) {
                            String provinceHtml = td.get(0).getAttribute("innerHTML");
                            if (provinceHtml.contains("a") && provinceHtml.contains("/")) {
                                m = PATTERN.matcher(provinceHtml);
                                while (m.find()) {
                                    provinceName = m.group(0);
                                }
                            }
                        } else {
                            String curCityHtml = td.get(0).getAttribute("innerHTML");
                            if (curCityHtml.contains("a") && curCityHtml.contains("/")) {
                                m = PATTERN.matcher(curCityHtml);
                                while (m.find()) {
                                    curCityName = m.group(0);
                                }
                            }
                        }
                        String cityHtml = td.get(1).getAttribute("innerHTML");
                        // 城市名称
                        String cityName = StrUtil.EMPTY;

                        if (cityHtml.contains("a") && cityHtml.contains("/")) {
                            m = PATTERN.matcher(cityHtml);
                            while (m.find()) {
                                cityName = m.group(0);
                            }
                        }

                        if (i == 2) {
                            // 为香港和澳门的话只判断到下标为2, 取出下标4的最高温度, 下标7的最低温度即可
                            if ("香港".equalsIgnoreCase(provinceName) || "澳门".equalsIgnoreCase(provinceName)) {
                                String maxTemp = td.get(4).getAttribute("innerHTML");
                                String minTemp = td.get(7).getAttribute("innerHTML");
                                saveResult(provinceName, cityName, maxTemp, minTemp);
                                // 重点, 为2且为香港和澳门的时候, 必须break跳出循环, 进行台湾的判断
                                break;
                            } else {// 不为香港和澳门的话, 保存省会城市的信息, 例如台湾-台北
                                String maxTemp = td.get(4).getAttribute("innerHTML");
                                String minTemp = td.get(7).getAttribute("innerHTML");
                                saveResult(provinceName, cityName, maxTemp, minTemp);
                            }
                        } else {
                            // 非上述两个城市, 即为台湾时
                            String maxTemp = td.get(3).getAttribute("innerHTML");
                            String minTemp = td.get(6).getAttribute("innerHTML");
                            saveResult(provinceName, curCityName, maxTemp, minTemp);
                        }

                    }
                }
            } catch (Exception e) {
                LOG.error("执行handleResult报错, 具体异常为: " + e.getMessage());
            }
        }
    }

    /**
     * 保存实体
     *
     * @param provinceName 省
     * @param cityName     市
     * @param maxTemp      最高温度
     * @param minTemp      最低温度
     */
    public static void saveResult(String provinceName, String cityName, String maxTemp, String minTemp) {
        TempDayPojo tblCityTemperatureDay = new TempDayPojo();
        tblCityTemperatureDay.setProvinceName(provinceName);
        tblCityTemperatureDay.setCityName(cityName);
        tblCityTemperatureDay.setCreateTime(new Date());
        tblCityTemperatureDay.setMaximumTemp(maxTemp);
        tblCityTemperatureDay.setMinimumTemp(minTemp);
        domesticCityDataUtilDay.tblCityTemperatureDayService.save(tblCityTemperatureDay);
    }
}

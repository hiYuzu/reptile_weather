package com.sinosoft.model;

import java.util.List;

/**
 * 当日天气返回结果
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2022/3/10 15:45
 */
public class NowWeatherModel {
    /**
     * 返回结果
     */
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result {
        /**
         * 地区信息
         */
        private Location location;
        /**
         * 天气数据
         */
        private Now now;
        /**
         * //数据更新时间（该城市的本地时间）
         */
        private String last_update;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Now getNow() {
            return now;
        }

        public void setNow(Now now) {
            this.now = now;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }

        public static class Location {
            /**
             * 地区ID
             */
            private String id;
            /**
             * 地区名称
             */
            private String name;
            /**
             * 所属国家
             */
            private String country;
            /**
             * 地区完整名称
             */
            private String path;
            /**
             * 时区
             */
            private String timezone;
            /**
             * 时区偏移
             */
            private String timezone_offset;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public String getTimezone_offset() {
                return timezone_offset;
            }

            public void setTimezone_offset(String timezone_offset) {
                this.timezone_offset = timezone_offset;
            }
        }

        public static class Now {
            /**
             * 天气现象文字
             */
            private String text;
            /**
             * 天气现象代码
             */
            private String code;
            /**
             * 温度，单位为c摄氏度
             */
            private String temperature;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }
        }
    }
}

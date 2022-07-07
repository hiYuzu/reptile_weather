package com.sinosoft.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SignatureException;

/**
 * 心知天气公私钥签名生成URL
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2022/3/10 15:16
 */
public class RealWeatherUtil {
    private static final String TQ_DAILY_WEATHER_URL = "https://api.seniverse.com/v3/weather/now.json";
    /**
     * 私钥
     */
    private static final String TQ_API_SECRET_KEY = "SkfYCuEaz6S1halUz";
    /**
     * 公钥
     */
    private static final String TQ_API_USER_ID = "PMyCSxAujfYV157Js";

    /**
     * 生成签名
     *
     * @param data 时间戳、公钥等参数
     * @return 签名
     * @throws SignatureException 通用签名异常
     */
    private static String generateSignature(String data) throws SignatureException {
        String result;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(TQ_API_SECRET_KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            result = new sun.misc.BASE64Encoder().encode(rawHmac);
        }
        catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    /**
     * 根据IP获取当日天气URL
     *
     * @return URL
     * @throws SignatureException 通用签名异常
     * @throws UnsupportedEncodingException 不支持字符编码
     */
    public static String generateNowUrl()  throws SignatureException, UnsupportedEncodingException {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String params = "ts=" + timestamp + "&ttl=1800&uid=" + TQ_API_USER_ID;
        String signature = URLEncoder.encode(generateSignature(params), "UTF-8");
        return TQ_DAILY_WEATHER_URL + "?" + params + "&sig=" + signature + "&location=ip";
    }
}

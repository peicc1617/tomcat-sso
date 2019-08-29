package xjtucad.util;

import java.security.MessageDigest;

/**
 * 字符串加密类，将用户名+当前系统时间的字符串进行MD5加密
 */
public class MD5 {
    private static final String encryModel="MD5";

    public static String md5(String str) {
        return encrypt(encryModel, str);
    }


    public static String encrypt(String algorithm, String str) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes());
            StringBuffer sb = new StringBuffer();
            byte[] bytes = md.digest();
            for (int i = 0; i < bytes.length; i++) {
                int b = bytes[i] & 0xFF;
                if (b < 0x10) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
}

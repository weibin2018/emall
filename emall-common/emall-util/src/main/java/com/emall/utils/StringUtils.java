package com.emall.utils;

import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.StringTokenizer;

/**
 * <p>
 *      字符串操作
 * </p>
 *
 * @author 魏斌
 * @version 1.0
 * @date 2018/2/6
 */
public final class StringUtils {

    private StringUtils(){}

    /**
     * 验证字符串非空
     * @param str
     * @return
     */
    public static boolean isNotNull(String str){
        if(null == str || str.trim().length() == 0){
            return false;
        }
        return true;
    }

    /**
     * 验证字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        return !isNotNull(str);
    }

    /**
     * 将字符串中的单引号、双引号进行转义
     */
    public static final String toReplace(String str){
        if(!isNotNull(str)) {
            throw new NullPointerException("需要转译的字符串不可以为空");
        }
        return str.replace("'","\\'" ).replace("\"", "\\\"");
    }

    /**
     * 将字符串拼接成Like查询需要的格式
     * @param str
     * @return
     */
    public static final String toLikeStr(String str){
        if(!isNotNull(str)) {
            throw new NullPointerException("需要转译的字符串不可以为空");
        }
        return '%'+toReplace(str)+'%';
    }

    /**
     * 验证是否有指定的字符或字符串，如果有则返回字符所在的索引
     * 如果是字符串，则返回字符串第一个字符的索引
     * @param str 待验证的字符串
     * @param validateStr 验证的字符或字符串
     * @return
     */
    public static final int validateStr(String validateStr,String str){
        return validateStr.indexOf(str);
    }

    /**
     * 将科学计数法的数字转换成正常形式
     * @param numberStr 采用科学计数法的数字
     * @return
     */
    public static String numberToStr(double numberStr){
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        return df.format(numberStr);
    }

    /**
     * 将字节数组中的数据 转换为字符串
     * @param data
     * @return
     */
    public static String  showByteArray(byte[] data){
        if(null == data){
            throw new NullPointerException("需要转换的数据不可以为空");
        }
        StringBuilder sb = new StringBuilder("{");
        for(byte b:data){
            sb.append(b).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }

    /**
     * 字符串分割
     * @return
     */
    public static String[] split(String str,String splitStr){
        int index = str.indexOf(splitStr);
        if(index == -1){
            return new String[]{str};
        }else{
            StringTokenizer st = new StringTokenizer(str,splitStr);
            String[] array = new String[st.countTokens()];
            int count = 0;
            while (st.hasMoreElements()) {
                array[count] = st.nextToken();
                count ++;
            }
            return array;
        }
    }

    /**
     * 字符串拼接
     * @param objs 拼接值
     * @return
     */
    public static String concat(Object ... objs) {
        if (null != objs && objs.length != 0) {
            StringBuilder builder = new StringBuilder(objs.length);
            for (Object object : objs) {
                if (null != object) {
                    builder.append(object);
                }
            }
            return builder.toString();
        }else{
            return "";
        }
    }

    /**
     *@Description byte 数组转字符串
     *@Param [bytes]
     *@Author weibin
     *@Date 2018/12/17 14:12
     *@Return java.lang.String
     **/
    public static final String byteToStr(byte[] bytes,Charset charset){
        if(null == bytes)
            throw new NullPointerException("待转换的字节数组不可以为空");
        return new String(bytes,charset);
    }

    /**
     * 二进制 转16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            builder.append(hex.toUpperCase());
        }
        return builder.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}

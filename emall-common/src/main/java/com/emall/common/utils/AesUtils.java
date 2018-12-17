package com.emall.common.utils;

import com.emall.common.constant.Constant;
import com.emall.common.log.LogUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * AES 加密解密工具类
 * @author 魏斌
 */
public final class AesUtils {

    /**
     * 秘钥标识
     */
    private static SecretKey secretKey;
    /**
     * 加密方式
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String KEY_ALGORITHM = "AES";
    /**
     * 密钥
     */
    private static final String PASSWORD_KEY = "12345678_PW";

    /**
     * 防止该类被实例化
     *  KeyGenerator 生成aes算法密钥
     *  初始化此密钥生成器，使其具有确定的密钥大小
     *  AES 要求密钥长度为 128
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     */
    private AesUtils(){
        try {
            KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            kg.init(128);
            secretKey = kg.generateKey();
        } catch (Exception e) {
            LogUtils.errorLog("初始化Aes失败",e);
        }
    };

    /**
     * 使用AES算法 加密，默认模式  AES/ECB
     * @param str
     */
    public byte[] encrypt(String str) throws Exception {
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(PASSWORD_KEY.getBytes(),KEY_ALGORITHM));
        return cipher.doFinal(str.getBytes(Constant.UTF8));
    }

    /**
     * 使用AES算法 解密
     * @param encrypt 待解密的密文
     * @return
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     */
    public String decrypt(byte[] encrypt) throws Exception{
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(PASSWORD_KEY.getBytes(),KEY_ALGORITHM));
        return new String(cipher.doFinal(encrypt),Constant.UTF8);
    }

    /**
     * 获取该类的实例
     * @return
     */
    public static AesUtils getInstance(){
        return SingletonHolder.instance;
    }

    /**
     * 内部类，用来实例化外部类
     * @author 魏斌
     *
     */
    private static class SingletonHolder{
        private final static  AesUtils instance = new AesUtils();
    }

    /**
     * 二进制 转16进制
     * @param buf
     * @return
     */
    public String parseByte2HexStr(byte buf[]) {
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
    public byte[] parseHexStr2Byte(String hexStr) {
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

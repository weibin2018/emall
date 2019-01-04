package com.emall.utils;

import com.emall.core.constant.Constant;
import com.emall.log.LogUtils;

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

}

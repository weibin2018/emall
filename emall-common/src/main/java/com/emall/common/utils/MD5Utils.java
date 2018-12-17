package com.emall.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
  * 
  * <pre>
  *		MD5加密程序
  *	</pre>                                                                                                  
  * 作    者：  魏斌                
  * 创建时间：  2014年9月23日
  * 版    本:   1.0
 */
public final class MD5Utils {
	
	/**
	 * 用来将字节转换成16进制表示的字符
	 */
	private final static  char[] hexDigits={'0','1','2','3','4','5','6','7','8','9',  
        'a','b','c','d','e','f'};  
	
	/**
	  * <pre>
	  * 	生成MD5编码
	  * </pre>
	  * @param  
	  * @see 
	  * @return 
	  * @throws
	 */
	public static String getMD5(byte[] source) throws NoSuchAlgorithmException {
        String s;
        try {  
            MessageDigest md= MessageDigest.getInstance("MD5");
            md.update(source);  
            //MD5的计算结果是一个128位的长整数，用字节表示为16个字节  
            byte[] tmp=md.digest();  
            //每个字节用16进制表示的话，使用2个字符(高4位一个,低4位一个)，所以表示成16进制需要32个字符  
            char[] str=new char[16*2];
			//转换结果中对应的字符位置
            int k=0;
			//对MD5的每一个字节转换成16进制字符
            for(int i=0;i<16;i++){
                byte byte0=tmp[i];
				//对字节高4位进行16进制转换
                str[k++]=hexDigits[byte0>>>4 & 0xf];
				//对字节低4位进行16进制转换
                str[k++]=hexDigits[byte0 & 0xf];
            }  
            s=new String(str);
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("获取MD5密文失败",e);
        }  
        return s;  
    }  
	
	/**
	  * <pre>
	  * 	获取指定信息的MD5加密密文
	  * </pre>
	  * @param  str 要加密的内容
	  * @see 
	  * @return 
	  * @throws NoSuchAlgorithmException
	 */
	public static String getMD5Str(String str) throws NoSuchAlgorithmException {
		return getMD5(str.getBytes());
	}  
}

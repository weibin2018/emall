package com.emall.common.utils;


import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


/**
 * 生成随机数工具类
 * @author Administrator
 *
 */
public final class RandomUtils {
	
	
	/**
	  * <pre>
	  * 	类的私有构造函数，防止该类被实例化 
	  * </pre>
	 */
	private RandomUtils(){}
	

	/**
	  * <pre>
	  * 	获取36位的UUID值
	  * </pre>
	  * @param  
	  * @see 
	  * @return 
	  * @throws
	 */
	public static final String getUUID(){
		return UUID.randomUUID().toString();
	}

	/**
	 * 在指定的数值之间生成随机数
	 * @param beginNum 开始数值
	 * @param endNum  结束数值
	 */
	public static final int rundom(int beginNum,int endNum){
		return ThreadLocalRandom.current().nextInt(beginNum, endNum);
	}
	
	/**
	 * 生成指定长度的随机数,随机数是0-9 之间的数字
	 * @param length 指定长度
	 * @return
	 */
	public static final String rundomByNumber(int length){
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i<length;i++){
			builder.append(rundom(0,10));
		}
		return builder.toString();
	}

	/**
	 *@Description 生成随机数，随机数不限制
	 *@Param [length]
	 *@Author weibin
	 *@Date 2018/12/17 12:22
	 *@Return
	 **/
	public static final String rundom(int length) {
		byte [] bytes = new byte[length];
		ThreadLocalRandom.current().nextBytes(bytes);
		return StringUtils.parseByte2HexStr(bytes);
	}
	
	/**
	 * 生成由年月日加随机数生成指定位数的随机数
	 * @param length 指定长度的随机数
	 */
	public static final String rundomByYMDR(int length){
		int month = DateUtils.getMonth(null);
		int day = DateUtils.getDay(null);
		return DateUtils.getYear(null)+""+(month < 10 ? "0" + month:month) +
			""+(day < 10 ? "0"+day:day)+""+DateUtils.getHour(null)+""+
			DateUtils.getMinute(null)+rundomByNumber(length);
	}

    /**
     * 生成短信验证码
     * @return
     */
    public static String roundCode() {
        return rundomByNumber(6);
    }
}

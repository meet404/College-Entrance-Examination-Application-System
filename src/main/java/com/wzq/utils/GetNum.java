package com.wzq.utils;

import java.util.Random;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
public class GetNum {

	/**
	 * 返回一个随机的8位验证码
	 *
	 * @return
	 */
	public static String getNum() {
		Random random = new Random();
		int res = random.nextInt(99999999 - 10000000 + 1) + 10000000;
		return String.valueOf(res);
	}

}

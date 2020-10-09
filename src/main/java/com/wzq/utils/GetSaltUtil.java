package com.wzq.utils;

import java.util.Random;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
public class GetSaltUtil {

	/**
	 * 生成16位随机盐
	 *
	 * @return
	 */
	public static String getSalt() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder(16);
		sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
		int len = sb.length();
		if (len < 16) {
			for (int i = 0; i < 16 - len; i++) {
				sb.append("0");
			}
		}
		String salt = sb.toString();
		return salt;
	}

}
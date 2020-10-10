package com.wzq.utils;

/**
 * @author wzq
 * @date 2020/10/10
 * @email 158957716@qq.com
 */
public class GetHtmlText {

	/**
	 * 封装邮件内容
	 *
	 * @return
	 */

	public static String subject() {
		String head = "邮件验证";
		return head;
	}

	public static String text(String text) {

		String html = "这封邮件是由系统发送，请勿回复。<br/>" +
				"你收到这封邮件是【系统测试】进行新用户注册发送的邮件激活验证。<br/>" +
				"点击下方链接进行邮件激活(如果链接不能点击，请复制地址到浏览器，然后直接打开。)。<br/>" +
				"<br/>" +
				"http://localhost:8080/active/" + text;
		return html;
	}

}

package com.wzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
@Controller
@RequestMapping("/common")
public class CommonController {

	@RequestMapping("/noauth")
	@ResponseBody
	public String unauthorized() {
		return "未授权无法访问";
	}

}

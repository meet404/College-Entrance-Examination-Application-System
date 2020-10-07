package com.wzq.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.wzq.utils.GuuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wzq
 * @date 2020/10/1
 * @email 158957716@qq.com
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("==========insert==========");
		this.setFieldValByName("gmtCreate", new Date(), metaObject);
		this.setFieldValByName("gmtModified", new Date(), metaObject);
		this.setFieldValByName("id", GuuidUtil.getUUID(),metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("==========update==========");
		this.setFieldValByName("gmtModified", new Date(), metaObject);
	}
}

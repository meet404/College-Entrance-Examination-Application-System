package com.wzq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wzq
 * @date 2020/10/6
 * @email 158957716@qq.com
 */
@Data
@TableName("head")
public class Heat {
	@TableId(type = IdType.INPUT)
	private Long id;
	private Long schoolId;
	private Integer heats;
}

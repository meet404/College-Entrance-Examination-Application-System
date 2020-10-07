package com.wzq.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/4
 * @email 158957716@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("major")
public class Major {

	@TableId(type = IdType.INPUT)
	@TableField(fill = FieldFill.INSERT)
	private Long id;

	private Long schoolId;

	private String name;

	private String dps;

	private String plc;

	private String els;

	@TableField(exist = false)
	private String schoolName;

	@TableField(exist = false)
	private School school;

}

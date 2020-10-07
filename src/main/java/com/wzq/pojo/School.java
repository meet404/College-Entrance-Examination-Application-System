package com.wzq.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wzq
 * @date 2020/10/2
 * @email 158957716@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("school")
public class School {

	@TableId(type = IdType.INPUT)
	@TableField(fill = FieldFill.INSERT)
	private Long id;

	@TableField("school_name")
	private String schoolName;

	private String introduction;

	@Version
	private Integer version;

	@TableLogic
	private Integer deleted;

	@TableField(fill = FieldFill.INSERT)
	private Date gmtCreate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date gmtModified;

}

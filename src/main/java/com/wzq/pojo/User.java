package com.wzq.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author wzq
 * @date 2020/10/5
 * @email 158957716@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

	@TableId(type = IdType.INPUT)
	private Long id;

	private String username;

	private String password;

	private Integer userStatus;

	private String gender;

	private String privateSalt;

	private String email;

	private Integer roleId;

	@TableLogic
	private Integer deleted;

	@TableField(fill = FieldFill.INSERT)
	private Date gmtCreate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date gmtModified;

	@TableField(exist = false)
	private String code;

}

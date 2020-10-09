package com.wzq.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/7
 * @email 158957716@qq.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tc_role")
public class Role {

	private Integer id;

	private String name;

	private String code;

	private String intro;

	@TableField(exist = false)
	private List<Permission> permissionList;

}

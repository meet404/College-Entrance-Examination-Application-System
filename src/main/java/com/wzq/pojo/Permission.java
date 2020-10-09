package com.wzq.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wzq
 * @date 2020/10/7
 * @email 158957716@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tc_permission")
public class Permission {

	private Integer id;

	private String name;

	private String code;

	private String url;

}

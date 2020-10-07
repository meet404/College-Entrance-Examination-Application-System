package com.wzq.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wzq
 * @date 2020/10/4
 * @email 158957716@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("score")
public class Score {

	@TableId(type = IdType.INPUT)
	@TableField(fill = FieldFill.INSERT)
	private Long id;

	private Long schoolId;

	private Integer year;

	private String maxScore;

	private String averageScore;

	private String minScore;

	private Integer minPrecedence;

	private String pcl;

	private String type;

	private String batch;

	@TableField(exist = false)
	private String schoolName;

}

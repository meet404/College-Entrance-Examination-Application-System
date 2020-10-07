package com.wzq;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzq.mapper.MajorMapper;
import com.wzq.mapper.SchoolMapper;
import com.wzq.mapper.ScoreMapper;
import com.wzq.pojo.Major;
import com.wzq.pojo.School;
import com.wzq.pojo.Score;
import com.wzq.service.HeatService;
import com.wzq.service.SchoolService;
import com.wzq.utils.GuuidUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TcDemo01ApplicationTests {

	@Autowired
	private MajorMapper majorMapper;

	@Autowired
	private ScoreMapper scoreMapper;

	@Autowired
	private SchoolMapper schoolMapper;

	@Autowired
	private HeatService heatService;

	@Autowired
	private SchoolService schoolService;

	@Test
	void contextLoads() {
		long uuid = GuuidUtil.getUUID();
		System.out.println(uuid);
	}

	@Test
	public void test(){
		List<Major> all = majorMapper.findAll();
		all.forEach(System.out::println);
	}

	@Test
	public void test2(){
		List<Major> all = majorMapper.findAll();
		all.forEach(System.out::println);
	}

	@Test
	public void test3(){
		List<Score> allBySchoolId = scoreMapper.findAllBySchoolId(100587486396284928L);
		allBySchoolId.forEach(System.out::println);
	}

	@Test
	public void test4(){
		heatService.updateHeat(100587486396284928L);
	}

	@Test
	public void test5(){
		System.out.println(schoolService.count());
	}

	@Test
	public void test6(){
		Page<School> page = new Page<>(1,10);
		schoolMapper.selectPage(page,null);
		List<School> list = page.getRecords();
		System.out.println(list);
	}

	@Test
	public void test7(){
		List<School> list = schoolService.findSchoolByName("test");
		System.out.println(list);
	}

}
